package petrsu.smartroom.android.srcli;

import android.content.Intent;
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

        //задать кнопки и их обработчики
        toQueue = (Button) findViewById (R.id.toQueue);
        toQueue.setOnClickListener(this);
        exitQueue = (Button) findViewById (R.id.exitQueue);
        exitQueue.setOnClickListener(this);

        //если реквест уже был отправлен
        if (KP.existingRequest(KP.gettingUsername) == 0)
        {
            //нельзя нажать кнопку подачи заявки
            exitQueue.setBackgroundColor(getResources().getColor(R.color.gray));
            exitQueue.setEnabled(false);
        } else
            {
                 //иначе нельзя отменить заявку
                 toQueue.setBackgroundColor(getResources().getColor(R.color.gray));
                 toQueue.setEnabled(false);
            }
    }



    //обработать нажатие кнопок
    public void onClick(View v){

        switch(v.getId()) {

            //обработать кнопку подачи заявки
            case R.id.toQueue:

                //послать реквест в сиб
                if (KP.registerRequest(KP.gettingUsername) == 0)
                {
                    //проверить вывод
                    System.out.println("REQUEST FROM " + KP.gettingUsername + " ADDED");

                    //изменить цвет кнопок после нажатия
                    toQueue.setBackgroundColor(getResources().getColor(R.color.gray));
                    toQueue.setEnabled(false);
                    exitQueue.setBackgroundColor(getResources().getColor(R.color.md_red_A400));
                    exitQueue.setEnabled(true);

                    //открыть вкладку очереди
                    Intent intentQueueList = new Intent();
                    intentQueueList.setClass(this, QueueList.class);
                    startActivity(intentQueueList);
                } else{
                    System.out.println("ERROR!!! CANT ADD REQUEST");
                }

                break;

            //обработать кнопку удаления заявки
            case R.id.exitQueue:

                //проверить существует ли реквест от данного пользователя
                if (KP.existingRequest(KP.gettingUsername) == 1)
                {
                    //если существует, удалить реквест из сиба
                    if (KP.deleteRequest(KP.gettingUsername) == 0)
                    {
                        System.out.println("REQUEST FROM" + KP.gettingUsername + "DELETEd");
                    } else{
                        System.out.println("ERROR!!! CANT DELETE REQUEST");
                    }
                }
                //если не существует - заблокировать эту кнопку для нажатия

                //проверить вывод

                //изменить цвет кнопок после нажатия
                toQueue.setBackgroundColor(getResources().getColor(R.color.md_light_green_A700));
                toQueue.setEnabled(true);
                exitQueue.setBackgroundColor(getResources().getColor(R.color.gray));
                exitQueue.setEnabled(false);

                //открыть вкладку очереди
                Intent intentQueueList = new Intent();
                intentQueueList.setClass(this, QueueList.class);
                startActivity(intentQueueList);


                break;
        }
    }
}
