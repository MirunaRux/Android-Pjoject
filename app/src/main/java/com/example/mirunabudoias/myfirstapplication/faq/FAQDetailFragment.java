package com.example.mirunabudoias.myfirstapplication.faq;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mirunabudoias.myfirstapplication.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FAQDetailFragment extends Fragment {


    private static final String ARG_PARAM_ID = "ARG_PARAM_ID";
    private int currentID;

    @BindView(R.id.tv_faq_detail_title)
    TextView faqDetailTitle;
    @BindView(R.id.tv_faq_detail_description)
    TextView faqDetailDescription;

    public FAQDetailFragment() {
        // Required empty public constructor
    }

    public static FAQDetailFragment newInstance(int id) {
        FAQDetailFragment fragment = new FAQDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentID = getArguments().getInt(ARG_PARAM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faqdetail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] questionsArray = getResources().getStringArray(R.array.questions);
        String[] answersArray = getResources().getStringArray(R.array.questions_answer);

        faqDetailTitle.setText(questionsArray[currentID]);
        faqDetailDescription.setText(answersArray[currentID]);

    }
}
