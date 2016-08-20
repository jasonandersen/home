node {

	stage 'Checkout'

	checkout(
		[$class: 'GitSCM', 
		  branches: [[name: '*/master']], 
		  doGenerateSubmoduleConfigurations: false, 
		  extensions: [], 
		  submoduleCfg: [], 
		  userRemoteConfigs: [[url: '/opt/code/ha-ext-weather-ws']]
		  ]
	  )
}
