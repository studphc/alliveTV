package p000;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.text.TextUtils;
import android.util.Log;
import androidx.leanback.R;
import androidx.leanback.widget.SearchBar;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class cf2 implements RecognitionListener {

    /* renamed from: a */
    public final /* synthetic */ SearchBar f8352a;

    public cf2(SearchBar searchBar) {
        this.f8352a = searchBar;
    }

    @Override // android.speech.RecognitionListener
    public final void onError(int i) {
        switch (i) {
            case 1:
                int i2 = SearchBar.f6125A;
                Log.w("SearchBar", "recognizer network timeout");
                break;
            case 2:
                int i3 = SearchBar.f6125A;
                Log.w("SearchBar", "recognizer network error");
                break;
            case 3:
                int i4 = SearchBar.f6125A;
                Log.w("SearchBar", "recognizer audio error");
                break;
            case 4:
                int i5 = SearchBar.f6125A;
                Log.w("SearchBar", "recognizer server error");
                break;
            case 5:
                int i6 = SearchBar.f6125A;
                Log.w("SearchBar", "recognizer client error");
                break;
            case 6:
                int i7 = SearchBar.f6125A;
                Log.w("SearchBar", "recognizer speech timeout");
                break;
            case 7:
                int i8 = SearchBar.f6125A;
                Log.w("SearchBar", "recognizer no match");
                break;
            case 8:
                int i9 = SearchBar.f6125A;
                Log.w("SearchBar", "recognizer busy");
                break;
            case 9:
                int i10 = SearchBar.f6125A;
                Log.w("SearchBar", "recognizer insufficient permissions");
                break;
            default:
                int i11 = SearchBar.f6125A;
                Log.d("SearchBar", "recognizer other error");
                break;
        }
        SearchBar searchBar = this.f8352a;
        searchBar.stopRecognition();
        searchBar.f6134i.post(new xe2(R.raw.lb_voice_failure, 0, searchBar));
    }

    @Override // android.speech.RecognitionListener
    public final void onPartialResults(Bundle bundle) {
        String str;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
        if (stringArrayList != null && stringArrayList.size() != 0) {
            String str2 = stringArrayList.get(0);
            if (stringArrayList.size() > 1) {
                str = stringArrayList.get(1);
            } else {
                str = null;
            }
            this.f8352a.f6127b.updateRecognizedText(str2, str);
        }
    }

    @Override // android.speech.RecognitionListener
    public final void onReadyForSpeech(Bundle bundle) {
        SearchBar searchBar = this.f8352a;
        searchBar.f6128c.showListening();
        searchBar.f6134i.post(new xe2(R.raw.lb_voice_open, 0, searchBar));
    }

    @Override // android.speech.RecognitionListener
    public final void onResults(Bundle bundle) {
        SearchBar.SearchBarListener searchBarListener;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
        SearchBar searchBar = this.f8352a;
        if (stringArrayList != null) {
            String str = stringArrayList.get(0);
            searchBar.f6130e = str;
            searchBar.f6127b.setText(str);
            if (!TextUtils.isEmpty(searchBar.f6130e) && (searchBarListener = searchBar.f6126a) != null) {
                searchBarListener.onSearchQuerySubmit(searchBar.f6130e);
            }
        }
        searchBar.stopRecognition();
        searchBar.f6134i.post(new xe2(R.raw.lb_voice_success, 0, searchBar));
    }

    @Override // android.speech.RecognitionListener
    public final void onRmsChanged(float f) {
        int i;
        if (f < RecyclerView.f7068F0) {
            i = 0;
        } else {
            i = (int) (f * 10.0f);
        }
        this.f8352a.f6128c.setSoundLevel(i);
    }

    @Override // android.speech.RecognitionListener
    public final void onBeginningOfSpeech() {
    }

    @Override // android.speech.RecognitionListener
    public final void onEndOfSpeech() {
    }

    @Override // android.speech.RecognitionListener
    public final void onBufferReceived(byte[] bArr) {
    }

    @Override // android.speech.RecognitionListener
    public final void onEvent(int i, Bundle bundle) {
    }
}
