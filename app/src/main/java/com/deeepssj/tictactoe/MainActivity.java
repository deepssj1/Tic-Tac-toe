package com.deeepssj.tictactoe;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    int active=0;
    public static int count = 0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
boolean gameactive=true;


public void dropin(View view) {


    ImageView counter = (ImageView) view;
    int tap_counter = Integer.parseInt(counter.getTag().toString());
    if (gamestate[tap_counter] == 2 && gameactive) {
        count=count + 1;
        gamestate[tap_counter] = active;
        counter.setTranslationY(-1500);
        if (active == 0) {
            counter.setImageResource(R.drawable.zero);
            active = 1;
        } else {
            counter.setImageResource(R.drawable.cross);
            active = 0;
        }
        counter.animate().translationYBy(1500).setDuration(300);
        int flag=0;
        for (int[] winposition : winPositions) {
            String winner = " ";
            if (gamestate[winposition[0]] == gamestate[winposition[1]] && gamestate[winposition[1]] == gamestate[winposition[2]] && gamestate[winposition[0]] != 2)  {
               flag=1;
                gameactive=false;

                if (active == 1) {
                    winner = "Player Using Zero has won !!";
                }
              if (active == 0) {
                    winner = "Player Using Cross Has won !!";
                }

                Button playbutton=(Button) findViewById(R.id.button2);
                TextView winnerText =(TextView)findViewById(R.id.textView2);
                winnerText.setText(winner);
                playbutton.setVisibility(View.VISIBLE);
                winnerText.setVisibility(View.VISIBLE);

            }

            }

        }


}
public void play(View view)
{
    Button playbutton=(Button) findViewById(R.id.button2);
    TextView winnerText =(TextView)findViewById(R.id.textView2);
    playbutton.setVisibility(View.INVISIBLE);
    winnerText.setVisibility(View.INVISIBLE);
    GridLayout gridLayout=(GridLayout)findViewById(R.id.GridLayout);
    for(int i=0;i<gridLayout.getChildCount();i++)
    {
        ImageView counter =(ImageView) gridLayout.getChildAt(i);
        counter.setImageDrawable(null);
    }
    for(int i=0;i<gamestate.length;i++)
    {
        gamestate[i]=2 ;
    }
    active=0;
    gameactive=true;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}