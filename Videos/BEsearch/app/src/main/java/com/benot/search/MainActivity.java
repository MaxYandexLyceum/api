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
import android.widget.EditText;
import android.widget.ImageView;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.AdapterView;
import android.view.View;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;


public class MainActivity extends Activity {


    private HashMap<String, Object> hs = new HashMap<>();
    private double numb = 0;

    private ArrayList<String> haj = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> poisklist = new ArrayList<>();

    private LinearLayout linear1;
    private LinearLayout linear3;
    private EditText edittext1;
    private ImageView imageview2;
    private ImageView imageview1;
    private LinearLayout all;
    private WebView webview1;
    private LinearLayout linear4;
    private Spinner spinner1;
    private ProgressBar progressbar1;

    private Intent ka = new Intent();
    private SharedPreferences pos;
    private Intent bhhjj = new Intent();
    private AlertDialog.Builder ggg;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.main);
        initialize(_savedInstanceState);
        initializeLogic();
    }

    private void initialize(Bundle _savedInstanceState) {

        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear3 = (LinearLayout) findViewById(R.id.linear3);
        edittext1 = (EditText) findViewById(R.id.edittext1);
        imageview2 = (ImageView) findViewById(R.id.imageview2);
        imageview1 = (ImageView) findViewById(R.id.imageview1);
        all = (LinearLayout) findViewById(R.id.all);
        webview1 = (WebView) findViewById(R.id.webview1);
        webview1.getSettings().setJavaScriptEnabled(true);
        webview1.getSettings().setSupportZoom(true);
        linear4 = (LinearLayout) findViewById(R.id.linear4);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
        pos = getSharedPreferences("pos", Activity.MODE_PRIVATE);
        ggg = new AlertDialog.Builder(this);

        imageview2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View _view) {
                chwareUtil.showMessage(getApplicationContext(), "Поиск");
                return true;
            }
        });

        imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                if (spinner1.getSelectedItemPosition() == 0) {
                    chwareUtil.showMessage(getApplicationContext(), "Выберите поисковую систему");
                } else {
                    if (spinner1.getSelectedItemPosition() == (1 + poisklist.size())) {
                        bhhjj.setClass(getApplicationContext(), PoskActivity.class);
                        startActivity(bhhjj);
                    } else {
                        if (!edittext1.getText().toString().equals("")) {
                            webview1.loadUrl(poisklist.get((int) spinner1.getSelectedItemPosition() - 1).get("link").toString().replace("9nsldvGPbygh8Rfr", edittext1.getText().toString()));
                        }
                    }
                }
                chwareUtil.hideKeyboard(getApplicationContext());
            }
        });

        imageview1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View _view) {
                chwareUtil.showMessage(getApplicationContext(), "Открыть в браузере");
                return true;
            }
        });

        imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                ka.setAction(Intent.ACTION_VIEW);
                ka.setData(Uri.parse(webview1.getUrl()));
                startActivity(ka);
            }
        });

        webview1.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
                final String _url = _param2;
                webview1.setVisibility(View.GONE);
                linear4.setVisibility(View.VISIBLE);
                super.onPageStarted(_param1, _param2, _param3);
            }

            @Override
            public void onPageFinished(WebView _param1, String _param2) {
                final String _url = _param2;
                webview1.setVisibility(View.VISIBLE);
                linear4.setVisibility(View.GONE);
                super.onPageFinished(_param1, _param2);
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
                final int _position = _param3;
                if (!(_position == 0)) {
                    if (_position == (1 + poisklist.size())) {
                        bhhjj.setClass(getApplicationContext(), PoskActivity.class);
                        startActivity(bhhjj);
                    } else {
                        if ("".equals(edittext1.getText().toString())) {
                            chwareUtil.showKeyboard(getApplicationContext());
                        } else {
                            webview1.loadUrl(poisklist.get((int) _position - 1).get("link").toString().replace("9nsldvGPbygh8Rfr", edittext1.getText().toString()));
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> _param1) {

            }
        });
    }

    private void initializeLogic() {
        webview1.setVisibility(View.INVISIBLE);
        linear4.setVisibility(View.GONE);
        if (pos.getString("joo", "").equals("")) {
            pos.edit().putString("joo", "[{\"link\":\"https://yandex.ru/search/touch/?text=9nsldvGPbygh8Rfr\",\"nazv\":\"Yandex\"},{\"link\":\"https://www.google.ru/search?q=9nsldvGPbygh8Rfr\",\"nazv\":\"Google\"}]").commit();
        }
        poisklist = new Gson().fromJson(pos.getString("joo", ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
        }.getType());
        haj.add("Выберите поисковую систему");
        for (int _repeat20 = 0; _repeat20 < (int) (poisklist.size()); _repeat20++) {
            haj.add(poisklist.get((int) numb).get("nazv").toString());
            numb++;
        }
        spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, haj));
        haj.add("Управление системами... ");
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
        ggg.setTitle("Вы уверены, что хотите выйти? ");
        ggg.setPositiveButton("ДА", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface _dialog, int _which) {
                finish();
            }
        });
        ggg.setNegativeButton("НЕТ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface _dialog, int _which) {

            }
        });
        ggg.create().show();
    }

}
