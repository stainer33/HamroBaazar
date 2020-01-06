package fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.e.hamrobaazar.R;
import com.e.hamrobaazar.TermPolicyActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class UrlFragment extends Fragment {
String url;

    public UrlFragment(String url) {
        this.url=url;

    }

    WebView webView;
    Button btnBack;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_url, container, false);

        webView=view.findViewById(R.id.webView);
        btnBack=view.findViewById(R.id.btnBack);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer, new FrontFragment());
                transaction.addToBackStack(null);


                transaction.commit();
            }
        });
        return view;
    }

}
