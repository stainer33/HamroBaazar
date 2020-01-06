package fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.e.hamrobaazar.MainActivity;
import com.e.hamrobaazar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FrontFragment extends Fragment {


    public FrontFragment() {
        // Required empty public constructor
    }
    public static Boolean terms =false;
    public static Boolean rules=false;
    public  static  Boolean tips =false;

    CheckBox checkTerms, checkRules , checkTips;
    Button btnAccept;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_front, container, false);

        checkTerms=view.findViewById(R.id.checkTerms);
        checkRules=view.findViewById(R.id.checkRules);
        checkTips=view.findViewById(R.id.checkTips);
        btnAccept=view.findViewById(R.id.btnAccept);

        final FragmentTransaction transaction = getFragmentManager().beginTransaction();


        checkTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terms=true;


                transaction.replace(R.id.fragmentContainer, new UrlFragment("https://hamrobazaar.com/terms.html"));
                transaction.addToBackStack(null);


                transaction.commit();

            }
        });

        checkRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules=true;

                transaction.replace(R.id.fragmentContainer, new UrlFragment("https://hamrobazaar.com/postrules.html"));
                transaction.addToBackStack(null);


                transaction.commit();
            }
        });

        checkTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tips=true;
                transaction.replace(R.id.fragmentContainer, new UrlFragment("https://hamrobazaar.com/safetytips.php?nohead=1"));
                transaction.addToBackStack(null);


                transaction.commit();

            }
        });



        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(terms == true && rules ==true && tips ==true) {

                    Intent intent =new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);}
                else
                {
                    Toast.makeText(getActivity(), "Accept all terms and condition", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
