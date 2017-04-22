package petrsu.smartroom.android.srcli;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11.05.16.
 */
public class QueueList  extends ActionBarActivity implements AdapterView.OnItemLongClickListener {

    private ListView qlistView;
    ArrayAdapter<String> arr;
    List<String> q;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.queue_list);

        qlistView = (ListView) findViewById(R.id.qlistView);
        q = new ArrayList<>();
        qlistView.setAdapter(arr);
        qlistView.setOnItemLongClickListener(this);

        //вывести реквесты из сиба по одному в список
        for (int x = 0; x < KP.getRequestCount(); x = x + 1) {
            q.add(KP.getRequestList(x));
        }

        arr = new ArrayAdapter<String>(this, R.layout.list_item, R.id.name, q);
        qlistView.setAdapter(arr);
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {


        return true;
    }

}