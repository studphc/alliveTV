package androidx.leanback.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.leanback.widget.SearchOrbView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.ViewOnClickListenerC1109d4;
import p000.af2;
import p000.cf2;
import p000.ye2;
import p000.ze2;

/* loaded from: classes.dex */
public class SearchBar extends RelativeLayout {

    /* renamed from: A */
    public static final /* synthetic */ int f6125A = 0;

    /* renamed from: a */
    public SearchBarListener f6126a;

    /* renamed from: b */
    public SearchEditText f6127b;

    /* renamed from: c */
    public SpeechOrbView f6128c;

    /* renamed from: d */
    public ImageView f6129d;

    /* renamed from: e */
    public String f6130e;

    /* renamed from: f */
    public String f6131f;

    /* renamed from: g */
    public String f6132g;

    /* renamed from: h */
    public Drawable f6133h;

    /* renamed from: i */
    public final Handler f6134i;

    /* renamed from: j */
    public final InputMethodManager f6135j;

    /* renamed from: k */
    public boolean f6136k;

    /* renamed from: l */
    public Drawable f6137l;

    /* renamed from: m */
    public final int f6138m;

    /* renamed from: n */
    public final int f6139n;

    /* renamed from: o */
    public final int f6140o;

    /* renamed from: p */
    public final int f6141p;

    /* renamed from: q */
    public final int f6142q;

    /* renamed from: r */
    public final int f6143r;

    /* renamed from: s */
    public SpeechRecognizer f6144s;

    /* renamed from: t */
    public SpeechRecognitionCallback f6145t;

    /* renamed from: u */
    public boolean f6146u;

    /* renamed from: v */
    public SoundPool f6147v;

    /* renamed from: w */
    public final SparseIntArray f6148w;

    /* renamed from: x */
    public boolean f6149x;

    /* renamed from: y */
    public final Context f6150y;

    /* renamed from: z */
    public SearchBarPermissionListener f6151z;

    /* loaded from: classes.dex */
    public interface SearchBarListener {
        void onKeyboardDismiss(String str);

        void onSearchQueryChange(String str);

        void onSearchQuerySubmit(String str);
    }

    /* loaded from: classes.dex */
    public interface SearchBarPermissionListener {
        void requestAudioPermission();
    }

    public SearchBar(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m1481a() {
        this.f6135j.hideSoftInputFromWindow(this.f6127b.getWindowToken(), 0);
    }

    /* renamed from: b */
    public final void m1482b() {
        String string = getResources().getString(androidx.leanback.R.string.lb_search_bar_hint);
        if (!TextUtils.isEmpty(this.f6132g)) {
            if (this.f6128c.isFocused()) {
                string = getResources().getString(androidx.leanback.R.string.lb_search_bar_hint_with_title_speech, this.f6132g);
            } else {
                string = getResources().getString(androidx.leanback.R.string.lb_search_bar_hint_with_title, this.f6132g);
            }
        } else if (this.f6128c.isFocused()) {
            string = getResources().getString(androidx.leanback.R.string.lb_search_bar_hint_speech);
        }
        this.f6131f = string;
        SearchEditText searchEditText = this.f6127b;
        if (searchEditText != null) {
            searchEditText.setHint(string);
        }
    }

    /* renamed from: c */
    public final void m1483c(boolean z) {
        if (z) {
            this.f6137l.setAlpha(this.f6143r);
            boolean isFocused = this.f6128c.isFocused();
            int i = this.f6141p;
            if (isFocused) {
                this.f6127b.setTextColor(i);
                this.f6127b.setHintTextColor(i);
            } else {
                this.f6127b.setTextColor(this.f6139n);
                this.f6127b.setHintTextColor(i);
            }
        } else {
            this.f6137l.setAlpha(this.f6142q);
            this.f6127b.setTextColor(this.f6138m);
            this.f6127b.setHintTextColor(this.f6140o);
        }
        m1482b();
    }

    public void displayCompletions(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new CompletionInfo(arrayList.size(), arrayList.size(), it.next()));
            }
        }
        displayCompletions((CompletionInfo[]) arrayList.toArray(new CompletionInfo[arrayList.size()]));
    }

    public Drawable getBadgeDrawable() {
        return this.f6133h;
    }

    public CharSequence getHint() {
        return this.f6131f;
    }

    public String getTitle() {
        return this.f6132g;
    }

    public boolean isRecognizing() {
        return this.f6149x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6147v = new SoundPool(2, 1, 0);
        int[] iArr = {androidx.leanback.R.raw.lb_voice_failure, androidx.leanback.R.raw.lb_voice_open, androidx.leanback.R.raw.lb_voice_no_input, androidx.leanback.R.raw.lb_voice_success};
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            this.f6148w.put(i2, this.f6147v.load(this.f6150y, i2, 1));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        stopRecognition();
        this.f6147v.release();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f6137l = ((RelativeLayout) findViewById(androidx.leanback.R.id.lb_search_bar_items)).getBackground();
        this.f6127b = (SearchEditText) findViewById(androidx.leanback.R.id.lb_search_text_editor);
        ImageView imageView = (ImageView) findViewById(androidx.leanback.R.id.lb_search_bar_badge);
        this.f6129d = imageView;
        Drawable drawable = this.f6133h;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        this.f6127b.setOnFocusChangeListener(new ye2(this, 0));
        this.f6127b.addTextChangedListener(new af2(this, new ze2(this, 0)));
        this.f6127b.setOnKeyboardDismissListener(new C0379q2(this));
        this.f6127b.setOnEditorActionListener(new C0386s2(this));
        this.f6127b.setPrivateImeOptions("escapeNorth,voiceDismiss");
        SpeechOrbView speechOrbView = (SpeechOrbView) findViewById(androidx.leanback.R.id.lb_search_bar_speech_orb);
        this.f6128c = speechOrbView;
        speechOrbView.setOnOrbClickedListener(new ViewOnClickListenerC1109d4(7, this));
        this.f6128c.setOnFocusChangeListener(new ye2(this, 1));
        m1483c(hasFocus());
        m1482b();
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.f6133h = drawable;
        ImageView imageView = this.f6129d;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            if (drawable != null) {
                this.f6129d.setVisibility(0);
            } else {
                this.f6129d.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setNextFocusDownId(int i) {
        this.f6128c.setNextFocusDownId(i);
        this.f6127b.setNextFocusDownId(i);
    }

    public void setPermissionListener(SearchBarPermissionListener searchBarPermissionListener) {
        this.f6151z = searchBarPermissionListener;
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        SpeechOrbView speechOrbView = this.f6128c;
        if (speechOrbView != null) {
            speechOrbView.setNotListeningOrbColors(colors);
        }
    }

    public void setSearchAffordanceColorsInListening(SearchOrbView.Colors colors) {
        SpeechOrbView speechOrbView = this.f6128c;
        if (speechOrbView != null) {
            speechOrbView.setListeningOrbColors(colors);
        }
    }

    public void setSearchBarListener(SearchBarListener searchBarListener) {
        this.f6126a = searchBarListener;
    }

    public void setSearchQuery(String str) {
        stopRecognition();
        this.f6127b.setText(str);
        setSearchQueryInternal(str);
    }

    public void setSearchQueryInternal(String str) {
        if (TextUtils.equals(this.f6130e, str)) {
            return;
        }
        this.f6130e = str;
        SearchBarListener searchBarListener = this.f6126a;
        if (searchBarListener != null) {
            searchBarListener.onSearchQueryChange(str);
        }
    }

    @Deprecated
    public void setSpeechRecognitionCallback(SpeechRecognitionCallback speechRecognitionCallback) {
        this.f6145t = speechRecognitionCallback;
        if (speechRecognitionCallback != null && this.f6144s != null) {
            throw new IllegalStateException("Can't have speech recognizer and request");
        }
    }

    public void setSpeechRecognizer(SpeechRecognizer speechRecognizer) {
        stopRecognition();
        SpeechRecognizer speechRecognizer2 = this.f6144s;
        if (speechRecognizer2 != null) {
            speechRecognizer2.setRecognitionListener(null);
            if (this.f6146u) {
                this.f6144s.cancel();
                this.f6146u = false;
            }
        }
        this.f6144s = speechRecognizer;
        if (this.f6145t != null && speechRecognizer != null) {
            throw new IllegalStateException("Can't have speech recognizer and request");
        }
    }

    public void setTitle(String str) {
        this.f6132g = str;
        m1482b();
    }

    public void startRecognition() {
        if (this.f6149x) {
            return;
        }
        if (!hasFocus()) {
            requestFocus();
        }
        if (this.f6145t != null) {
            this.f6127b.setText("");
            this.f6127b.setHint("");
            this.f6145t.recognizeSpeech();
            this.f6149x = true;
            return;
        }
        if (this.f6144s == null) {
            return;
        }
        if (getContext().checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            SearchBarPermissionListener searchBarPermissionListener = this.f6151z;
            if (searchBarPermissionListener != null) {
                searchBarPermissionListener.requestAudioPermission();
                return;
            }
            throw new IllegalStateException("android.permission.RECORD_AUDIO required for search");
        }
        this.f6149x = true;
        this.f6127b.setText("");
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        this.f6144s.setRecognitionListener(new cf2(this));
        this.f6146u = true;
        this.f6144s.startListening(intent);
    }

    public void stopRecognition() {
        if (!this.f6149x) {
            return;
        }
        this.f6127b.setText(this.f6130e);
        this.f6127b.setHint(this.f6131f);
        this.f6149x = false;
        if (this.f6145t == null && this.f6144s != null) {
            this.f6128c.showNotListening();
            if (this.f6146u) {
                this.f6144s.cancel();
                this.f6146u = false;
            }
            this.f6144s.setRecognitionListener(null);
        }
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6134i = new Handler();
        this.f6136k = false;
        this.f6148w = new SparseIntArray();
        this.f6149x = false;
        this.f6150y = context;
        Resources resources = getResources();
        LayoutInflater.from(getContext()).inflate(androidx.leanback.R.layout.lb_search_bar, (ViewGroup) this, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_search_bar_height));
        layoutParams.addRule(10, -1);
        setLayoutParams(layoutParams);
        setBackgroundColor(0);
        setClipChildren(false);
        this.f6130e = "";
        this.f6135j = (InputMethodManager) context.getSystemService("input_method");
        this.f6139n = resources.getColor(androidx.leanback.R.color.lb_search_bar_text_speech_mode);
        this.f6138m = resources.getColor(androidx.leanback.R.color.lb_search_bar_text);
        this.f6143r = resources.getInteger(androidx.leanback.R.integer.lb_search_bar_speech_mode_background_alpha);
        this.f6142q = resources.getInteger(androidx.leanback.R.integer.lb_search_bar_text_mode_background_alpha);
        this.f6141p = resources.getColor(androidx.leanback.R.color.lb_search_bar_hint_speech_mode);
        this.f6140o = resources.getColor(androidx.leanback.R.color.lb_search_bar_hint);
    }

    public void displayCompletions(CompletionInfo[] completionInfoArr) {
        this.f6135j.displayCompletions(this.f6127b, completionInfoArr);
    }
}
