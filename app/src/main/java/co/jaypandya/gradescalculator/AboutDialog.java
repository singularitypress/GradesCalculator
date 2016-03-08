package co.jaypandya.gradescalculator;

import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AboutDialog extends DialogFragment implements View.OnClickListener {

    public static AboutDialog

        newInstance(int helpResId)	{
            AboutDialog abt = new AboutDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("about_resource", helpResId);
            abt.setArguments(bundle);

            return abt;
        }

        @Override
        public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            this.setCancelable(true);
            int style = DialogFragment.STYLE_NORMAL, theme = 0;
            setStyle(style,theme);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle)  {
            View v = inflater.inflate(R.layout.fragment_about_dialog, container, false);

            TextView tv = (TextView)v.findViewById(R.id.about_message);
            tv.setText(getActivity().getResources().getText(getArguments().getInt("about_resource")));

            Button closeBtn = (Button)v.findViewById(R.id.btn_close);
            closeBtn.setOnClickListener(this);
            return v;
        }

        public void onClick(View v) {
            dismiss();
        }
}
