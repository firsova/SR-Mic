package petrsu.smartroom.android.srcli;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 11.05.16.
 */
public class QueueButtons  extends ActionBarActivity implements View.OnClickListener {
    private Button toQueue;
    private Button exitQueue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.queue_buttons);
        
        toQueue = (Button) findViewById (R.id.toQueue);
        toQueue.setOnClickListener(this);
        exitQueue = (Button) findViewById (R.id.exitQueue);
        exitQueue.setOnClickListener(this);
    }
    public void onClick(View v){

        switch(v.getId()) {

      /* toQueue button */
            case R.id.toQueue:

                break;

      /* exitQueue button */
            case R.id.exitQueue:

                break;
        }
    }
}
