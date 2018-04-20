app_controller = ae.ARApplicationController:shared_instance()
app_controller:require('./scripts/include.lua')
app = AR:create_application(AppType.Slam, "bear")
app:load_scene_from_json("res/simple_scene.json","demo_scene")

scene = app:get_current_scene()

local version = app:get_engine_version()
local is_anim = true
local NOAMRL_POD = 1
local STAR_POD = 2
local current_pod = NOAMRL_POD

app.on_loading_finish = function()
	pod_anim_test()
end

function pod_anim_test()
	anim = scene.bear:pod_anim()
					 :on_complete(function() 
					 	ARLOG('pod anim done')
					 end)
					 :anim_repeat(true)
					 :start()
					 
	--点击模型打开url
	scene.bear.on_click = function()
		app:open_url("com.99bill.kuaiqian")
	end

	--点击按钮暂停/开始动画
	scene.pause.on_click = function()
		if(is_anim)
		then
			is_anim = false
			scene.pause:replace_texture("/res/texture/video_resume.png","uDiffuseTexture")
			anim:pause()
		else 
			is_anim = true
			scene.pause:replace_texture("/res/texture/video_pause.png","uDiffuseTexture")
			anim:resume()
		end
	end
end











