package com.example.mirunabudoias.myfirstapplication.user;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mirunabudoias.myfirstapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddUserFragment extends Fragment {
    private static final String ARG_USER = "ARG_USER";

    private User currentUser;

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.et_addUser_name)
    public TextInputEditText etName;

    @BindView(R.id.et_addUser_age)
    public TextInputEditText etAge;

    @BindView(R.id.et_addUser_address)
    public TextInputEditText etAddress;

    private boolean hasExtra;

    public AddUserFragment() {
        // Required empty public constructor
    }


    public static AddUserFragment newInstance(User user) {
        AddUserFragment fragment = new AddUserFragment();
        if (user != null) {
            Bundle args = new Bundle();
            args.putSerializable(ARG_USER, user);
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentUser = (User) getArguments().getSerializable(ARG_USER);
            hasExtra = true;
        } else {
            currentUser = new User();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(hasExtra) {
            initViews();
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void initViews(){
        etName.setText(currentUser.name);
        etAge.setText(String.valueOf(currentUser.age));
        etAddress.setText(currentUser.address);

    }
}
