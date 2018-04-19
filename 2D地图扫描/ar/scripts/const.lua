-- utils.lua --
function LOAD_CONST()
	AppType = {}
	-- AppType.None = 0
	-- AppType.ImageTrack = 1
	AppType.Imu = 2
	AppType.ImageTrack = 3
	AppType.Slam = 4

	-- Device Orientation -- 
	DeviceOrientation = {}
	DeviceOrientation.Portrait = 0
	DeviceOrientation.Left = 1
	DeviceOrientation.Right = 2
	
	EventType = {}
	EventType.Scroll = 2
	EventType.ScrollDown = 9
	EventType.ScrollUp = 11
    EventType.BatchLoadFinish = 200
    EventType.BatchLoadProgressUpdate = 201


	-- SDK LUA MSG TYPE --
    -- UI --
    MSG_TYPE_VIEW_VISIBLE_TYPE = 30000
    ViewVisibleType = {}
    ViewVisibleType.ShowAllButton  = 0
    ViewVisibleType.HideAllButton  = 1
    ViewVisibleType.ShowShotButton = 2
    ViewVisibleType.HideShotButton = 3
    ViewVisibleType.ShowTopButton  = 4
    ViewVisibleType.HideTopButton  = 5


	-- shake --
	MSG_TYPE_SHAKE = 10000
	MSG_TYPE_OPEN_SHAKE = 10001
	MSG_TYPE_STOP_SHAKE = 10002
	MAX_SHAKE_THRESHOLD = 9.8

	-- track -- 
	MSG_TYPE_OPEN_TRACK = 10101
	MSG_TYPE_STOP_TRACK = 10102

	MSG_TYPE_TRACK_TIPS = 10103
	TrackTips = {}
	TrackTips.trackedDistanceTooFar = 1
	TrackTips.trackedDistanceTooNear = 2
	TrackTips.trackedDistanceNormal = 3


	-- camera --
	MSG_TYPE_CAMERA_CHANGE = 10200
	MSG_TYPE_ENABLE_FRONT_CAMERA = 10201

	-- remote debug --
	MST_TYPE_REMOTE_DEBUG_REC = 10300
	MST_TYPE_REMOTE_DEBUG_SEND = 10301

	-- WebContent Handle
	MSG_TYPE_WEB_OPERATION = 10400

	-- model click --
	MSG_TYPE_INITIAL_CLCIK = 10500
	
	-- voice api --
	MSG_TYPE_VOICE_START = 2001
	MSG_TYPE_VOICE_STOP = 2002
	MSG_TYPE_VOICE_SHOW_MIC_ICON = 2003
    MSG_TYPE_VOICE_HIDE_MIC_ICON = 2004
	
	--voice status --
	VOICE_STATUS_READYFORSPEECH = 0
	VOICE_STATUS_BEGINNINGOFSPEECH = 1
	VOICE_STATUS_ENDOFSPEECH = 2
	VOICE_STATUS_ERROR = 3
	VOICE_STATUS_RESULT = 4
	VOICE_STATUS_RESULT_NO_MATCH = 5
	VOICE_STATUS_PARTIALRESULT = 6
	VOICE_STATUS_CANCLE = 7
	
	--voice error status --
	VOICE_ERROR_STATUS_NULL = 0
	VOICE_ERROR_STATUS_SPEECH_TIMEOUT = 1
	VOICE_ERROR_STATUS_NETWORK = 2
	VOICE_ERROR_STATUS_INSUFFICIENT_PERMISSIONS = 3
	-- voice api end --

	-- html --
	MSG_TYPE_HTML_OPERATION = 10500
	HtmlOperation = {}
	HtmlOperation.htmlLoad = 0
	HtmlOperation.loadFinish = 1
	HtmlOperation.modelUpdate = 2
	HtmlOperation.updateFinish = 3
	
  	-- tts api --
  	MSG_TYPE_TTS_SPEAK = 2005
  	MSG_TYPE_TTS_STOP = 2006
  	MSG_TYPE_TTS_PAUSE = 2007
  	MSG_TYPE_TTS_RESUME = 2008
    
    -- tts status --
    TTS_STATUS_READYFORTTS = 1
    TTS_STATUS_ENDOFTTS = 2
    TTS_STATUS_ERROR = 3
    -- tts api end --

    -- loading status --
    LOAD_STATUS_DOWNLOAD_RETRY_SHOWDIALOG = 3010
    LOAD_STATUS_DOWNLOAD_ANSWER = 3021
    -- loading status end --
	

    -- slam 
    MSG_TYPE_SLAM_RESET = 4100
    MSG_TYPE_SLAM_DIRECTION_GUIDE = 4101
    
    MSG_TYPE_START_SLAM = 4200

    -- paddle gesture --
	PADDLE_GESTURE_CONTROL = 5001
    PADDLE_GESTURE_STATUS_DETECTED = 5002
    GestureType = {}
    GestureType.Point = 1
    GestureType.Palm = 2
    GestureType.Fist = 3
    GestureType.OK= 4
    GestureType.Other = 5
    -- paddle gesture end --
	
	-- action api --
	MSG_TYPE_CLOSE_AR = 10301
	MSG_TYPE_SEND_VALUE = 10401
	

	-- filter --
    MSG_TYPE_FILTER_START               = 1065
    MSG_TYPE_FILTER_STOP                = 1067
    MSG_TYPE_FILTER_UPDATE              = 1069
    MSG_TYPE_FILTER_DISABLE_TECHNIQUE   = 1071
    MSG_TYPE_FILTER_RESET               = 1072
    MSG_TYPE_FILTER_DISABLE_TARGET      = 1073
    MSG_TYPE_FILTER_ADJUST              = 1074

    ResetType = {}
    ResetType.update = 0
    ResetType.add    = 1
    ResetType.delete = 2

    AdjustType = {}
    AdjustType.int   = 0
    AdjustType.float = 1
    AdjustType.point = 2
    AdjustType.vec3  = 3
    AdjustType.vec4  = 4
    AdjustType.size  = 5
    AdjustType.map   = 6
    AdjustType.mat3  = 7
    AdjustType.mat4  = 8

    -- filter end --


    -- http url request --

    MSG_TYPE_LUA_URL_REQUEST = 9001
    MSG_TYPE_LUA_REQUEST_STATUS = 9002
    MSG_TYPE_LUA_REQUEST_ANSWER  = 9003
    UrlStatus = {}
    UrlStatus.NetworkError = 1
    UrlStatus.ParamError = 2

    -- http url request end--


	ARLOG('load const')
end

LOAD_CONST()
--  utils.lua end -- 
