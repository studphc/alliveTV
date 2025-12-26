package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;

/* renamed from: androidx.appcompat.widget.j */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0101j implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ SearchView f1622a;

    public ViewOnClickListenerC0101j(SearchView searchView) {
        this.f1622a = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String flattenToShortString;
        SearchView searchView = this.f1622a;
        ImageView imageView = searchView.f1397t;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f1393p;
        if (view == imageView) {
            searchView.m274o(false);
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
            View.OnClickListener onClickListener = searchView.f1374O;
            if (onClickListener != null) {
                onClickListener.onClick(searchView);
                return;
            }
            return;
        }
        if (view == searchView.f1399v) {
            searchView.m265f();
            return;
        }
        if (view == searchView.f1398u) {
            searchView.m268i();
            return;
        }
        if (view == searchView.f1400w) {
            SearchableInfo searchableInfo = searchView.f1388f0;
            if (searchableInfo != null) {
                try {
                    if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                        Intent intent = new Intent(searchView.f1367H);
                        ComponentName searchActivity = searchableInfo.getSearchActivity();
                        if (searchActivity == null) {
                            flattenToShortString = null;
                        } else {
                            flattenToShortString = searchActivity.flattenToShortString();
                        }
                        intent.putExtra("calling_package", flattenToShortString);
                        searchView.getContext().startActivity(intent);
                        return;
                    }
                    if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                        searchView.getContext().startActivity(searchView.m263d(searchView.f1368I, searchableInfo));
                        return;
                    }
                    return;
                } catch (ActivityNotFoundException unused) {
                    Log.w("SearchView", "Could not find voice search activity");
                    return;
                }
            }
            return;
        }
        if (view == searchAutoComplete) {
            searchView.m264e();
        }
    }
}
