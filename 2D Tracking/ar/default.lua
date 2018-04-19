app_controller = ae.ARApplicationController:shared_instance()
app_controller:require('./scripts/include.lua')

--创建图像跟踪
app = AR:create_application(AppType.ImageTrack, "map scene")
--从Json中加载场景，并激活场景scene
app:load_scene_from_json("res/simple_scene.json","scene")
current_scene = app:get_current_scene()
app:set_gl_cull_face(true)

app.on_loading_finish = function()
    local root_node = current_scene:get_root_node()
	io.write("play music..")
	root_node:play_audio("/res/media/bg.mp3", -1, 0)
	root_node:play_pod_animation_all(1, true)
end

-- 跟丢回调，显示鸟瞰视角
app.on_target_lost = function()
    setBirdEyeView()
    local root_node = current_scene:get_root_node()
    root_node:set_rotation_by_xyz(0.0, 0.0, -35)
end

-- 找到识别图，复位
app.on_target_found = function()
    local root_node = current_scene:get_root_node()
    root_node:set_rotation_by_xyz(0.0, 0.0, 0.0)
end

-- 调整相机位置
function setBirdEyeView()
    -- params 相机的位置
    -- params 相机看向的位置
    -- params 相机Y轴方向
    -- params 切换相机位置时是否使用动画方式
    app:set_camera_look_at("-50.0, -480.0, 380.0","-35, 0, 0", "0.0, 1.0, 0.0")
end
