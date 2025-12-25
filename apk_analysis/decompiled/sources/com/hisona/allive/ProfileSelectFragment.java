package com.hisona.allive;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ProfileSelectFragment extends DialogFragment {
    public RecyclerView u0;
    public v v0;
    public LinearLayoutManager w0;
    public int x0;
    public int y0;
    public OnListItemClickListener z0;

    /* loaded from: classes2.dex */
    public interface OnBackPressedListener {
        void onBackPressed();
    }

    /* loaded from: classes2.dex */
    public interface OnListItemClickListener {
        void onItemClick(View view, int i);
    }

    public static ProfileSelectFragment newInstance() {
        return new ProfileSelectFragment();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_profile, (ViewGroup) null);
        this.u0 = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.ProfileDialogStyle).setTitle(getResources().getString(R.string.profile_title)).setView(inflate).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).create();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.w0 = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.u0.setLayoutManager(this.w0);
        v vVar = new v(this);
        this.v0 = vVar;
        this.u0.setAdapter(vVar);
        this.y0 = 0;
        this.x0 = -1;
        return create;
    }

    public void setClickListener(OnListItemClickListener onListItemClickListener) {
        this.z0 = onListItemClickListener;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, p72] */
    public void setData(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = JsonParser.parseString(str).getAsJsonObject().getAsJsonArray("list").iterator();
        while (it.hasNext()) {
            JsonObject asJsonObject = it.next().getAsJsonObject();
            String asString = asJsonObject.get(MimeTypes.BASE_TYPE_IMAGE).getAsString();
            String asString2 = asJsonObject.get("profilename").getAsString();
            ?? obj = new Object();
            obj.a = asString;
            obj.b = asString2;
            arrayList.add(obj);
        }
        v vVar = this.v0;
        ArrayList arrayList2 = vVar.d;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        vVar.notifyDataSetChanged();
    }
}
