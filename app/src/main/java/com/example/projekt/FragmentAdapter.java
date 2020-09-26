package com.example.projekt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

class FragmentAdapter extends FragmentStatePagerAdapter {

    FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new AddTaskFragment();
        else if(position == 1)
            return new TaskListFragment();
        else
            return new SensorFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Create a task";
        } else if(position == 1 ){
            return "Task list";
        }

        return "Sensors";
    }
}
