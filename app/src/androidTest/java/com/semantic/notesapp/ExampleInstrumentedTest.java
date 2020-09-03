package com.semantic.notesapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import com.semantic.notesapp.Activity.MainActivity;
import com.semantic.notesapp.Fragmetn.FirstFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import kotlin.jvm.JvmField;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule @JvmField
    ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    FragmentScenario<FirstFragment> fragmentFragmentScenario = FragmentScenario.launch(FirstFragment.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.semantic.notesapp", appContext.getPackageName());
    }

    @Test
    public void runView(){


       /* fragmentFragmentScenario.onFragment(new FragmentScenario.FragmentAction<FirstFragment>() {
            @Override
            public void perform(@NonNull FirstFragment fragment) {
                Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

//                assertThat();

            }
        });*/

      /*  scenario.onFragment { fragment ->
                assertThat(fragment.dialog).isNotNull()
            assertThat(fragment.requireDialog().isShowing).isTrue()
        }*/
        onView(withId(R.id.rv_notes_view)).inRoot(isDialog())
                .check(ViewAssertions.matches(ViewMatchers.withText("I am a fragment")));
    }
}