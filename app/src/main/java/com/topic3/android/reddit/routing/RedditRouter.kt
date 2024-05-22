package com.topic3.android.reddit.routing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.topic3.android.reddit.R



/**
 * Класс, определяющий экраны, которые есть в нашем приложении.
 *
 * Эти объекты должны соответствовать файлам, которые есть в пакете screens
 */
sealed class Screen(val titleResId: Int) {
  object Home : Screen(R.string.home)
  object Subscriptions : Screen(R.string.subreddits)
  object NewPost : Screen(R.string.new_post)
  object MyProfile : Screen(R.string.my_profile)
  object ChooseCommunity : Screen(R.string.choose_community)
}

object RedditRouter {
  var currentScreen: MutableState<Screen> = mutableStateOf(
      Screen.Home
  )

  private var previousScreen: MutableState<Screen> = mutableStateOf(
      Screen.Home
  )

  fun navigateTo(destination: Screen) {
    previousScreen.value = currentScreen.value
    currentScreen.value = destination
  }

  fun goBack() {
    currentScreen.value = previousScreen.value
  }
}