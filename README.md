# Afiliya-App
Android App Afiliya
--
This is repository for Afiliya-App made by team Mobile Development on this group.
##
Initial Step to Make Afiliya-App
--
Our beginning step in making *Afiliya* was to discuss and plan the design of the app's layout, features, flow, and so on. Initially, our plan was to create an app with many features supporting Indonesian MSMEs and culture, such as *books*, *articles*, *events*, *shop*, *news*, and others. However, after careful consideration both in terms of capabilities and time, we decided to focus on fewer features but can bring useful, fun and interesting experiences to users, such as e-commerce (affiliate) and events. Furthermore, we decided to implement these features on separate layouts to ease the code implementation and provide a more convenient user experience.
##
First Step to Make Afiliya-App
--
First thing first to make Afiliya-App is design the framework or mock design on Figma before integrating the design in Android Studio. On this mock design, we make sure what the layout design, color, features, and the flow. 
Here's our framework API that we make on Figma Platform:
![Group 51](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/82781749-77e7-4104-ab89-9296166b1754)
![Group 32](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/73041377-d411-4a44-9c81-2d3f84b3d56d)
![Group 34](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/14c0c49a-6013-4093-87b3-6b870d565946)
![Group 5](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/8476f6a1-d72b-4d81-88c0-d129ec8e486c)
![Group 35](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/4634b43c-709d-463e-a785-2dfb7fb6021d)
![Frame 7](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/467d215a-eea8-4ae6-a04b-2dfa883919e6)
![Notifikasi Beranda](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/abc92a83-f29a-410f-b507-b70d5cf22426)
![Group 7](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/a5924356-a449-495f-84ec-9c31d4636452)
![Group 9](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/b1c22d2b-fcca-41bf-9615-09665dd8563c)
![Group 11](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/2a3175f5-cba8-4c6a-8236-0822e9a14756)
![Group 12](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/90c427f9-8453-4dd9-82f9-11dd20a146e6)
![Group 13](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/66fb85eb-5ba0-4d37-982d-733da7474c9f)
![Group 16](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/89463781-7965-4a25-801f-9893bd087cd4)
![Group 18](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/a0ea8ae9-ab4a-4b23-879b-5dd27e5846ce)
![Group 20](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/b777016e-68a3-402c-ad12-ffa9570185c8)
![Group 21](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/08e005a1-27bf-4bbf-8e8e-af5513f07057)
![Group 23](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/d9ae1c7b-04b4-4124-bac7-968959008fb8)
![Group 24](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/0dc014ff-c9da-4d11-8f10-eb25c25dcb2c)
![Detail Acara](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/d7304bf7-a088-46a2-a62f-43b6461d838a)
![Hal Hadiah](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/1188709a-1915-42c9-9d9d-d9db0c66f99e)
![Group 49](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/6171b2d1-80c7-46b1-b600-18f01dd76418)
![Group 50](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/2bd2250e-183b-43a2-accc-e939f62e7722)
![Group 42](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/69656d2c-4a93-438a-9f2e-c3e0d2e49dcc)
![Group 41](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/723ae1b9-7acf-4fd9-9c6c-906992a952c1)
![Group 25](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/563bf903-54f2-4686-bd86-1ab19881bc09)
![Group 28](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/54172454-98cb-4229-91ac-aad17943c358)
![Group 26](https://github.com/Capstone-Project-CH2-PS070/Afiliya-App/assets/144432360/cf422cda-5c7e-466b-808e-16b35bdcf4df)
##
Implement Mock Design to Android Studio
--
After the app design was completed in figma, we moved on to implementing the design into the android studio project. In implementing this design, we chose to use Jetpack Compose instead of traditional XML, because UI/UX implementation is easier. In developing the Afiliya application, we first created a splash screen page, login page, registration, and authentication page using google and phone number. Next, we created the main features of the application in the form of the main page (home), verification page to become an affiliate, shop page, user, and page for entering product images to be purchased. 
##
Connecting Android Studio to Github Organization Project
--
To simplify communication and teamwork, during the app development process, our team connected the android studio app project with the github organization project that we had created earlier. This makes it easier for us to implement the app design in the form of an app project, both among the mobile development team and with the teams from machine learning and cloud computing who provide datasets and APIs for the "afiliya" app.
##
Lybrary on Afiliya-App
--
Here's some library we use to make Afiliya working
###
Retrofit
--
implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'
implementation 'com.squareup.okhttp3:okhttp:4.10.0'
implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
implementation 'com.google.code.gson:gson:2.9.0'
implementation "com.squareup.okhttp3:okhttp-sse:4.9.3"
