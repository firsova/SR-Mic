package petrsu.smartroom.android.srcli;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by user on 11.05.16.
 */
public class QueueList  extends ActionBarActivity implements AdapterView.OnItemLongClickListener {
    private ListView qlistView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.queue_list);

        qlistView = (ListView) findViewById(R.id.qlistView);
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {


        return true;
    }

}


