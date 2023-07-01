package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TimeUtils;
import android.view.View;
import android.widget.ImageView;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private ArrayList<User> users = new ArrayList<>();

    private RecyclerView usersRecyclerView = null;

    private void generateRandomUsers(int numUsersToGenerate)
    {
        Random random = new Random();

        random.setSeed(System.currentTimeMillis());

        User currentUser = null;

        for (int currentUserIndex = 0; currentUserIndex < numUsersToGenerate; currentUserIndex++)
        {
            currentUser = new User();

            currentUser.name = "Name" + random.nextInt();

            currentUser.description = "Description " + random.nextInt();

            currentUser.followed = random.nextBoolean();

            this.users.add(
                currentUser
            );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        this.generateRandomUsers(20);

        UsersAdapter.instance = new UsersAdapter(this.users, this);

        this.usersRecyclerView = findViewById(R.id.UsersRecyclerView);

        this.usersRecyclerView.setAdapter(UsersAdapter.instance);

        this.usersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}