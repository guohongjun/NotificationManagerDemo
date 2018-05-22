package cn.liusiqian.schemedemo;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Set;

/**
 * Créé par liusiqian 16/11/19.
 */

public class TargetAcitivity extends BaseSchemeAcitivity
{
    private TextView tvContent;

    @Override
    protected void loadData()
    {
        StringBuilder sb = new StringBuilder();
        Set<String> keys = mParams.keySet();
        for(String s:keys){
            sb.append(s).append(" = ").append(mParams.get(s)).append("\n");
        }
        tvContent.setText(sb.toString());
    }

    @Override
    protected void initWidgets(Bundle savedInstanceState)
    {
        tvContent = (TextView) findViewById(R.id.txt_content);
    }

    @Override
    protected int setLayoutRes()
    {
        return R.layout.activity_target;
    }
}
