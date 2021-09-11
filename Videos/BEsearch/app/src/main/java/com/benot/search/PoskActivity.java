package com.benot.search;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;

import java.util.*;
import java.util.regex.*;
import java.text.*;

import org.json.*;

import java.util.HashMap;
import java.util.ArrayList;

import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.graphics.Typeface;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;


public class PoskActivity extends Activity {


    private String ediitt = "";
    private String ediit = "";
    private HashMap<String, Object> koo = new HashMap<>();
    private double selec = 0;
    private HashMap<String, Object> nnn = new HashMap<>();

    private ArrayList<HashMap<String, Object>> posikliss = new ArrayList<>();
    private ArrayList<String> shabloni = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> lmap = new ArrayList<>();

    private LinearLayout linear1;
    private LinearLayout linear2;
    private ListView poisklist;
    private Spinner spinner1;
    private Button savebutt;

    private SharedPreferences pos;
    private Intent cale = new Intent();
    private AlertDialog.Builder dialoque;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.posk);
        initialize(_savedInstanceState);
        initializeLogic();
    }

    private void initialize(Bundle _savedInstanceState) {

        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        poisklist = (ListView) findViewById(R.id.poisklist);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        savebutt = (Button) findViewById(R.id.savebutt);
        pos = getSharedPreferences("pos", Activity.MODE_PRIVATE);
        dialoque = new AlertDialog.Builder(this);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
                final int _position = _param3;
                selec = _position;
                if (0 == _position) {
                    poisklist.setAdapter(new PoisklistAdapter(posikliss));
                }
                if (1 == _position) {
                    lmap.clear();
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Google");
                    nnn.put("link", "https://www.google.ru/search?q=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Yandex");
                    nnn.put("link", "https://yandex.ru/search/touch/?text=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Mail.ru");
                    nnn.put("link", "https://go.mail.ru/msearch?q=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "DuckDuckGo");
                    nnn.put("link", "https://duckduckgo.com/?q=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    poisklist.setAdapter(new PoisklistAdapter(lmap));
                }
                if (2 == _position) {
                    lmap.clear();
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Google Market");
                    nnn.put("link", "https://www.google.com/search?tbm=shop&q=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Yandex Market");
                    nnn.put("link", "https://yandex.ru/search/touch/?text=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "E-katalog");
                    nnn.put("link", "https://www.e-katalog.ru/ek-list.php?search_=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Aliexpress");
                    nnn.put("link", "https://m.aliexpress.ru/wholesale/9nsldvGPbygh8Rfr.html?channel=direct&keywords=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Avito");
                    nnn.put("link", "https://m.avito.ru/rossiya?q=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "OZON");
                    nnn.put("link", "https://www.ozon.ru/search/?from_global=true&text=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Lamoda");
                    nnn.put("link", "https://m.lamoda.ru/catalogsearch/result/?q=9nsldvGPbygh8Rfr&submit=y&gender_section=men");
                    lmap.add(nnn);
                    poisklist.setAdapter(new PoisklistAdapter(lmap));
                }
                if (3 == _position) {
                    lmap.clear();
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Youtube");
                    nnn.put("link", "https://m.youtube.com/results?search_query=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Yandex Efir");
                    nnn.put("link", "https://yandex.ru/efir?stream_active=serp&search_text=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Twitch");
                    nnn.put("link", "https://m.twitch.tv/search?term=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    poisklist.setAdapter(new PoisklistAdapter(lmap));
                }
                if (4 == _position) {
                    lmap.clear();
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Spotify");
                    nnn.put("link", "https://open.spotify.com/search/results/9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "SoundCloud");
                    nnn.put("link", "https://m.soundcloud.com/search/results?q=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Youtube Music");
                    nnn.put("link", "https://music.youtube.com/search?q=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Hitmo");
                    nnn.put("link", "https://ruv.hotmo.org/search?q=9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    poisklist.setAdapter(new PoisklistAdapter(lmap));
                }
                if (5 == _position) {
                    lmap.clear();
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Yandex Maps");
                    nnn.put("link", "https://yandex.ru/maps/12/smolensk/search/9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "2GIS");
                    nnn.put("link", "https://m.2gis.ru/search/9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    poisklist.setAdapter(new PoisklistAdapter(lmap));
                }
                if (6 == _position) {
                    lmap.clear();
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Google Translator (ru-en) ");
                    nnn.put("link", "https://translate.google.com/?hl=ru&sl=ru&tl=en&text=9nsldvGPbygh8Rfr &op=translate");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Google Translator (en-ru) ");
                    nnn.put("link", "https://translate.google.com/?hl=ru&en=en&tl=ru&text=9nsldvGPbygh8Rfr &op=translate");
                    lmap.add(nnn);
                    nnn = new HashMap<>();
                    nnn.put("nazv", "Reverso");
                    nnn.put("link", "https://context.reverso.net/перевод/русский-английский/9nsldvGPbygh8Rfr");
                    lmap.add(nnn);
                    poisklist.setAdapter(new PoisklistAdapter(lmap));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> _param1) {

            }
        });

        savebutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                pos.edit().putString("joo", new Gson().toJson(posikliss)).commit();
                chwareUtil.showMessage(getApplicationContext(), "Сохранено");
                cale.setClass(getApplicationContext(), MainActivity.class);
                startActivity(cale);
            }
        });
    }

    private void initializeLogic() {

        savebutt.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/ftb.ttf"), 1);
        posikliss = new Gson().fromJson(pos.getString("joo", ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
        }.getType());
        shabloni.add("Мои сайты");
        shabloni.add("Поисковые системы");
        shabloni.add("Товары");
        shabloni.add("Видео");
        shabloni.add("Музыка");
        shabloni.add("Карты");
        shabloni.add("Переводчики");
        spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, shabloni));
        poisklist.setAdapter(new PoisklistAdapter(posikliss));
    }

    @Override
    protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {

        super.onActivityResult(_requestCode, _resultCode, _data);

        switch (_requestCode) {

            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        dialoque.setTitle("Внимание");
        dialoque.setMessage("При выходе из управления системами несохранённые данные потеряются. Продолжить? ");
        dialoque.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface _dialog, int _which) {
                cale.setClass(getApplicationContext(), MainActivity.class);
                startActivity(cale);
            }
        });
        dialoque.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface _dialog, int _which) {

            }
        });
        dialoque.create().show();
    }

    public void _func() {
        poisklist.setAdapter(new PoisklistAdapter(posikliss));
    }


    public class PoisklistAdapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        public PoisklistAdapter(ArrayList<HashMap<String, Object>> _arr) {
            _data = _arr;
        }

        @Override
        public int getCount() {
            return _data.size();
        }

        @Override
        public HashMap<String, Object> getItem(int _index) {
            return _data.get(_index);
        }

        @Override
        public long getItemId(int _index) {
            return _index;
        }

        @Override
        public View getView(final int _position, View _v, ViewGroup _container) {
            LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View _view = _v;
            if (_view == null) {
                _view = _inflater.inflate(R.layout.cust, null);
            }

            final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
            final TextView poiskname = (TextView) _view.findViewById(R.id.poiskname);
            final Button delete = (Button) _view.findViewById(R.id.delete);

            if (selec == 0) {
                delete.setText("Удалить");
                poiskname.setText(posikliss.get((int) _position).get("nazv").toString());
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View _view) {
                        posikliss.remove((int) (_position));
                        chwareUtil.showMessage(getApplicationContext(), "Удалено");
                        _func();
                    }
                });
            } else {
                delete.setText("Добавить");
                poiskname.setText(lmap.get((int) _position).get("nazv").toString());
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View _view) {
                        nnn = new HashMap<>();
                        nnn = lmap.get((int) _position);
                        posikliss.add(nnn);
                        chwareUtil.showMessage(getApplicationContext(), "Добавлено");
                    }
                });
            }

            return _view;
        }
    }


}
