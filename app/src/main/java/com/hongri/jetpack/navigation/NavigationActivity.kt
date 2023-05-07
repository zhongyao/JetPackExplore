package com.hongri.jetpack.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongri.jetpack.R

/**
 * Navigation:
 * 三大件：
 * Navigation Graph：导航图，包含了所有导航相关信息的XML资源。一般防止在res/navigation目录下
 *
 * NavHost：容器，用来显示Fragment的，即Activity中的fragment，要求实现NavHost
 *
 * NavController：在NavHost中管理应用导航的对象
 *
 * 1、可视化的页面导航图，可以编辑各个组件之间的跳转关系
 * 2、优雅的支持Fragment之间的转场动画
 * 3、通过第三方的插件（SafeArgs（Gradle插件））支持Fragment之间类型安全的参数传递
 * 4、通过NavigationUI类，对菜单，底部导航，抽屉菜单导航进行方便统一的管理
 * 5、支持通过deeplink直接定位到Fragment
 *
 */
class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }
}