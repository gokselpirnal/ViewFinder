package com.gokselpirnal.viewfinder.viewfinder;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

/**
 * Created by gokselpirnal on 26/09/2016.
 */

public class ViewFinder {

    public static void bind(Activity activity) {

        for (Field field : activity.getClass().getDeclaredFields()) {
            FindView annotation = field.getAnnotation(FindView.class);

            if (annotation != null) {
                try {
                    field.set(activity, activity.findViewById(annotation.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static View bind(Fragment fragment, LayoutInflater layoutInflater, ViewGroup viewGroup) {

        View view = layoutInflater.inflate(fragment.getClass().getAnnotation(FindViewGroup.class).value(), viewGroup, false);

        for (Field field : fragment.getClass().getDeclaredFields()) {
            FindView annotation = field.getAnnotation(FindView.class);

            if (annotation != null) {
                try {
                    field.set(fragment, view.findViewById(annotation.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return view;
    }

}

