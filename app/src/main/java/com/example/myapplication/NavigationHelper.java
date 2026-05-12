package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class NavigationHelper {

    /**
     * Set up global navigation for the Bottom Navigation Bar.
     * Use this in onCreate() of every activity that includes bottom_navigation.xml
     */
    public static void setupNavigation(final Activity activity) {

        // 1. Home Button Navigation
        View navHome = activity.findViewById(R.id.navHome);
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                if (!(activity instanceof MainActivity)) {
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                }
            });
        }

        // 2. Info Button (Developer Info) Navigation
        View navInfo = activity.findViewById(R.id.navInfo);
        if (navInfo != null) {
            navInfo.setOnClickListener(v -> {
                if (!(activity instanceof DevInfoActivity)) {
                    Intent intent = new Intent(activity, DevInfoActivity.class);
                    activity.startActivity(intent);
                }
            });
        }

        // 3. Profile Button Navigation
        View navProfile = activity.findViewById(R.id.navProfile);
        if (navProfile != null) {
            navProfile.setOnClickListener(v -> {
                if (!(activity instanceof ProfileActivity)) {
                    Intent intent = new Intent(activity, ProfileActivity.class);
                    activity.startActivity(intent);
                }
            });
        }
    }
}