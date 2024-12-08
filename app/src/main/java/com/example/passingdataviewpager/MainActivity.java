package com.example.passingdataviewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements InputFragment.OnInputListener {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private DisplayFragment displayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        displayFragment = new DisplayFragment();
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, new InputFragment(), displayFragment);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(position == 0 ? "صفحة الكتابة" : "صفحة العرض")
        ).attach();
    }

    @Override
    public void sendInput(String input) {
        displayFragment.updateText(input);
        viewPager.setCurrentItem(1);
    }
}
