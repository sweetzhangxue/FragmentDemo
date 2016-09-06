package com.example.sweet_xue.fragmenttewo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by sweet_xue on 2/9/16.
 */
public class MenuFragment extends Fragment implements OnItemClickListener {

    private ListView listView;

    private ArrayAdapter<String> arrayAdapter;

    private String[] menuItems = {"sound", "Dispaly"};

    //是否是双页模式。如果一个Activity中包含两个Fragment，就是双页模式
    private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        arrayAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, menuItems);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.menu_list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.details_layout) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (isTwoPane) {
            Fragment fragment = null;
            if (position == 0) {
                fragment = new SoundFragment();
            } else if (position == 1) {
                fragment = new DisplayFragment();
            }
            getFragmentManager().beginTransaction().replace(R.id.details_layout, fragment).commit();
        } else {
            Intent intent = null;
            if (position == 0) {
                intent = new Intent(getActivity(), SoundActivity.class);
            } else if (position == 1) {
                intent = new Intent(getActivity(), DisplayActivity.class);
            }
            startActivity(intent);
        }
    }
}
