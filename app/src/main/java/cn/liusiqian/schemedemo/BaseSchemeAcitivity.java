package cn.liusiqian.schemedemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Créé par liusiqian 16/11/19.
 */

public abstract class BaseSchemeAcitivity extends AppCompatActivity
{
    protected Map<String,String> mParams;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutRes());
        initData(getIntent());
        initWidgets(savedInstanceState);
        loadData();
    }

    protected abstract void loadData();

    protected abstract void initWidgets(Bundle savedInstanceState);

    protected void initData(Intent intent)
    {
        if(intent == null || intent.getData() == null){
            return;
        }
        Uri uri = intent.getData();
        Set<String> set = uri.getQueryParameterNames();
        mParams = new HashMap<>();
        for(String s:set)
        {
            mParams.put(s,uri.getQueryParameter(s));
        }
    }

    protected abstract @LayoutRes int setLayoutRes();
}
