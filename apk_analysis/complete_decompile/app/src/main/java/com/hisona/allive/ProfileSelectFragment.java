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

    /* renamed from: u0 */
    public RecyclerView f15901u0;

    /* renamed from: v0 */
    public C1088v f15902v0;

    /* renamed from: w0 */
    public LinearLayoutManager f15903w0;

    /* renamed from: x0 */
    public int f15904x0;

    /* renamed from: y0 */
    public int f15905y0;

    /* renamed from: z0 */
    public OnListItemClickListener f15906z0;

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
        this.f15901u0 = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.ProfileDialogStyle).setTitle(getResources().getString(R.string.profile_title)).setView(inflate).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).create();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.f15903w0 = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.f15901u0.setLayoutManager(this.f15903w0);
        C1088v c1088v = new C1088v(this);
        this.f15902v0 = c1088v;
        this.f15901u0.setAdapter(c1088v);
        this.f15905y0 = 0;
        this.f15904x0 = -1;
        return create;
    }

    public void setClickListener(OnListItemClickListener onListItemClickListener) {
        this.f15906z0 = onListItemClickListener;
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
            obj.f25056a = asString;
            obj.f25057b = asString2;
            arrayList.add(obj);
        }
        C1088v c1088v = this.f15902v0;
        ArrayList arrayList2 = c1088v.f16015d;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        c1088v.notifyDataSetChanged();
    }
}
