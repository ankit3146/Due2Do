package due2do.mobile.com.duetodo;

/* References
[1] “Getting user name, lastname and ID in Firebase,” android -
    Getting user name, lastname and ID in Firebase - Stack Overflow. [Online].
    Available: https://stackoverflow.com/questions/42056333/getting-user-name-lastname-and-id-in-firebase.
    [Accessed: 28-Feb-2018].
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {

    private TextView aname;
    private Button signOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        signOutBtn = (Button) findViewById(R.id.sout);
        aname = (TextView) findViewById(R.id.authname);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String name = user.getDisplayName();
        aname.setText("Welcome " + name);

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Dashboard.this, MainActivity.class));
            }
        });
    }
}
