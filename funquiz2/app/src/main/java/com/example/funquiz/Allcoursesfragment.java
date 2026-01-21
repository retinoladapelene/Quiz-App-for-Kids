package com.example.funquiz;

import android.graphics.Color; // Import Color class
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView; // Import CardView
import androidx.fragment.app.Fragment;

public class Allcoursesfragment extends Fragment {

    // Member variables to hold references to navigation TextViews
    private TextView navSport, navScience, navFood, navHistory, navQuiz;

    public Allcoursesfragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_allcoursesfragment, container, false);

        // Find CardViews by their IDs
        ImageView cardSport = view.findViewById(R.id.card_materi_sport);
        ImageView cardScience = view.findViewById(R.id.card_materi_science);
        ImageView cardFood = view.findViewById(R.id.card_materi_food);
        ImageView cardHistory = view.findViewById(R.id.card_materi_history);

        // Initialize navigation TextViews from the parent activity
        // It's crucial that these IDs exist in the parent activity's layout
        navQuiz = requireActivity().findViewById(R.id.nav_quiz);
        navHistory = requireActivity().findViewById(R.id.nav_history);
        navScience = requireActivity().findViewById(R.id.nav_science);
        navSport = requireActivity().findViewById(R.id.nav_sport);
        navFood = requireActivity().findViewById(R.id.nav_food);


        cardSport.setOnClickListener(v -> {
            navigateTo(new SportFragment());
            setSelectedCategory(navSport);
        });

        cardScience.setOnClickListener(v -> {
            navigateTo(new ScienceFragment());
            setSelectedCategory(navScience);
        });

        cardFood.setOnClickListener(v -> {
            navigateTo(new FoodFragment());
            setSelectedCategory(navFood);
        });

        cardHistory.setOnClickListener(v -> {
            navigateTo(new HistoryFragment());
            setSelectedCategory(navHistory);
        });

        return view;
    }

    private void navigateTo(Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null) // Allows going back to Allcoursesfragment
                .commit();
    }

    private void setSelectedCategory(TextView selectedView) {
        // Use the already initialized member variables
        TextView[] categories = {navQuiz, navHistory, navScience, navSport, navFood};

        for (TextView category : categories) {
            if (category != null) {
                category.setBackground(null); // Remove background
                category.setTextColor(Color.BLACK); // Set text to black
            }
        }

        if (selectedView != null) {
            selectedView.setBackgroundResource(R.drawable.bg_nav_selected); // Set selected background
            selectedView.setTextColor(Color.WHITE); // Set text to white
        }
    }
}