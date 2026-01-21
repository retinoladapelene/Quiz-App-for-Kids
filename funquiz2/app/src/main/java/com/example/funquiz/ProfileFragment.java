package com.example.funquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView nameText = view.findViewById(R.id.user_name_text_view);
        TextView emailText = view.findViewById(R.id.user_email_text_view);
        ImageView profileImage = view.findViewById(R.id.profileImage);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(requireContext());
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (account != null) {
            nameText.setText(account.getDisplayName());
            emailText.setText(account.getEmail());
            Glide.with(this).load(account.getPhotoUrl()).into(profileImage);
        } else if (user != null) {
            nameText.setText(user.getDisplayName());
            emailText.setText(user.getEmail());
            Glide.with(this).load(user.getPhotoUrl()).into(profileImage);
        }

        return view;
    }
}
