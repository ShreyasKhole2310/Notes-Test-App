package com.semantic.notesapp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.semantic.notesapp.Activity.MainActivity
import com.semantic.notesapp.Adapter.RecyclerAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SampleTest {
    @Rule @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun launchDialogFragmentAndVerifyUI() {
        // Use launchFragment to launch the dialog fragment in a dialog.



        onView(withId(R.id.fab)).perform(click())
        /*scenario.onFragment { fragment ->
//            assertThat(fragment.dialog).isNotNull()
            assertThat(fragment.isVisible).isTrue()
        }*/
        /*var scenario2 = launchFragmentInContainer<FirstFragment>()


        var scenario = launchFragmentInContainer<SecondFragment>()
*/
        onView(withId(R.id.textview_first)).perform(clearText(), closeSoftKeyboard())

        onView(withId(R.id.textview_first)).perform(typeText("This is yet to be tested\n\n\t\t\t\n\n"), closeSoftKeyboard())
//        onView(withId(R.id.btn_done)).perform(click())

//        onView(withId(R.id.btn_done)).perform(click())

        // Now use espresso to look for the fragment's text view and verify it is displayed.
       /* Espresso.onView(ViewMatchers.withId(R.id.textView)).inRoot(isDialog())
                .check(ViewAssertions.matches(ViewMatchers.withText("I am a fragment")));*/
    }

    @Test
    fun checkData(){
        onView(withId(R.id.fab)).perform(click())
        onView(withId(R.id.textview_first)).check(matches(withText(R.string.hello_first_fragment)))
    }

    @Test
    fun updateData(){
        onView(withId(R.id.fab)).perform(click())
        onView(withId(R.id.textview_first)).perform(typeText("  // First, scroll to the view holder using the isInTheMiddle matcher.     \n\n " +
                "   // Match the text in an item below the fold and check that it's displayed."))

//        onView(withId(R.id.btn_done)).perform(click())
    }

    @Test
    fun clickRecyclerItem(){
        onView(withId(R.id.rv_notes_view)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerAdapter.ViewHolder>(6, click()))

        onView(withId(R.id.rv_notes_view)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerAdapter.ViewHolder>(9, click()))

        onView(withId(R.id.rv_notes_view)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerAdapter.ViewHolder>(2, click()))

    }

}