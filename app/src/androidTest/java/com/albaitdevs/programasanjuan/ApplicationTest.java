package com.albaitdevs.programasanjuan;

import android.app.Application;
import android.content.Intent;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

//        Intent mLaunchIntent = new Intent(getInstrumentation()
//                .getTargetContext(), LaunchActivity.class);
//        startActivity(mLaunchIntent, null, null);
//        final Button launchNextButton =
//                (Button) getActivity()
//                        .findViewById(R.id.launch_next_activity_button);
    }
//
//    @MediumTest
//    public void testNextActivityWasLaunchedWithIntent() {
//        startActivity(mLaunchIntent, null, null);
//        final Button launchNextButton =
//                (Button) getActivity()
//                        .findViewById(R.id.launch_next_activity_button);
//        launchNextButton.performClick();
//
//        final Intent launchIntent = getStartedActivityIntent();
//        assertNotNull("Intent was null", launchIntent);
//        assertTrue(isFinishCalled());
//
//        final String payload =
//                launchIntent.getStringExtra(NextActivity.EXTRAS_PAYLOAD_KEY);
//        assertEquals("Payload is empty", LaunchActivity.STRING_PAYLOAD, payload);
//    }
}