-- 视频Demo

app_controller = ae.ARApplicationController:shared_instance()
app_controller:require('./scripts/include.lua')

--创建图像跟踪
app = AR:create_application(AppType.ImageTrack, "audio scene")
--从Json中加载场景，并激活场景scene
app:load_scene_from_json("res/simple_scene.json","scene")
scene = app:get_current_scene()
app:set_gl_cull_face(true)

local video_plane_node = scene:get_node_by_name("videoPlane")
local video
local is_pause = false

app.on_loading_finish = function()
    app.device:open_imu(1)
    video = scene.videoPlane:video()
                            :path('/res/media/bb8-render.mp4')
                            :repeat_count(-1)
                            :start()

    scene.videoPlane.on_click = function()
        if(is_pause)
        then
            -- 打开视频
            is_pause = false
            video:resume()
        else
            -- 暂停视频
            is_pause = true
            video:pause()
        end
    end
end

-- 跟丢回调，暂停
app.on_target_lost = function()
    video:pause()
end

-- 找到识别图
app.on_target_found = function()
    -- 复位
    local root_node = scene:get_root_node()
    root_node:set_rotation_by_xyz(0.0, 0.0, 0.0)
    video:resume()
end