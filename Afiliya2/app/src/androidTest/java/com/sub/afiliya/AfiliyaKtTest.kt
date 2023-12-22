package com.sub.afiliya

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.sub.afiliya.ui.MainActivity
import org.junit.Rule
import org.junit.Test

class AfiliyaKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun buyItemUsingSearch() {
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.search)).performTextInput("Razer Cobra Pro")
        composeTestRule.onNodeWithTag("item12").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithTag("detailScreen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Razer Cobra Pro").assertIsDisplayed()
        composeTestRule.onNodeWithTag("counterAdd", useUnmergedTree = true).performClick().performClick().performClick()
        composeTestRule.onNodeWithTag("productCounter").assertTextEquals("3")
        composeTestRule.onNodeWithTag("counterMinus", useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag("productCounter").assertTextEquals("2")
        composeTestRule.onNodeWithContentDescription("Order Button", useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag("cartScreen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Razer Cobra Pro").assertIsDisplayed()
        composeTestRule.onNodeWithTag("counterMinus", useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag("productCounter").assertTextEquals("1")
        composeTestRule.onNodeWithContentDescription("Order Button", useUnmergedTree = true).performClick()
    }

    @Test
    fun allNavigation() {
        composeTestRule.onNodeWithTag("item1").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithTag("detailScreen").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Icon Back").performClick()
        composeTestRule.onNodeWithTag("homeScreen").assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.menu_cart)).performClick()
        composeTestRule.onNodeWithTag("cartScreen").assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.menu_profile)).performClick()
        composeTestRule.onNodeWithTag("profileScreen").assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.menu_home)).performClick()
        composeTestRule.onNodeWithTag("homeScreen").assertIsDisplayed()
    }
}
}