package cubes.vaktmester.stanisic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cubes.vaktmester.stanisic.BuildConfig;
import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.animations.Animations;

public class HomeActivity extends AppCompatActivity {
        private TextView textViewVersion;
        private PopupMenu popupMenu;
        private ImageView imageViewMenu;
        private RelativeLayout relativeLayoutBuildings, relativeLayoutSheet,relativeLayoutTickets,relativeLayoutChat;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_layout);

        initComp();
        addListener();


    }

    @Override
    protected void onResume() {
        super.onResume();
        Animations.setScaleAnimation(relativeLayoutBuildings,100);
        Animations.setScaleAnimation(relativeLayoutSheet,200);
        Animations.setScaleAnimation(relativeLayoutTickets,300);
        Animations.setScaleAnimation(relativeLayoutChat,400);
    }

    private void addListener() {

        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupMenu = new PopupMenu(getApplicationContext(),imageViewMenu);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(getApplicationContext(), "Popup menu item clicked", Toast.LENGTH_SHORT).show();

                        return true;
                    }
                });

                popupMenu.inflate(R.menu.pop_up);
                popupMenu.show();
            }
        });
    }

    private void initComp() {
        textViewVersion = findViewById(R.id.textViewVersion);
        textViewVersion.setText(textViewVersion.getText().toString() + BuildConfig.VERSION_NAME);
        imageViewMenu = findViewById(R.id.imageViewMore);

        //incijalizujem relativ lejautove radi animacija

        relativeLayoutBuildings = findViewById(R.id.relativeLayoutBuildings);
        relativeLayoutChat = findViewById(R.id.relativeLayoutChat);
        relativeLayoutTickets = findViewById(R.id.relativeLayoutTickets);
        relativeLayoutSheet = findViewById(R.id.relativeLayoutSheet);
    }
}
