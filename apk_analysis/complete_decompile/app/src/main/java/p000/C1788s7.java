package p000;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* renamed from: s7 */
/* loaded from: classes.dex */
public final class C1788s7 {

    /* renamed from: A */
    public NestedScrollView f26263A;

    /* renamed from: C */
    public Drawable f26265C;

    /* renamed from: D */
    public ImageView f26266D;

    /* renamed from: E */
    public TextView f26267E;

    /* renamed from: F */
    public TextView f26268F;

    /* renamed from: G */
    public View f26269G;

    /* renamed from: H */
    public ListAdapter f26270H;

    /* renamed from: J */
    public final int f26272J;

    /* renamed from: K */
    public final int f26273K;

    /* renamed from: L */
    public final int f26274L;

    /* renamed from: M */
    public final int f26275M;

    /* renamed from: N */
    public final int f26276N;

    /* renamed from: O */
    public final boolean f26277O;

    /* renamed from: P */
    public final HandlerC1714q7 f26278P;

    /* renamed from: a */
    public final Context f26280a;

    /* renamed from: b */
    public final AlertDialog f26281b;

    /* renamed from: c */
    public final Window f26282c;

    /* renamed from: d */
    public final int f26283d;

    /* renamed from: e */
    public CharSequence f26284e;

    /* renamed from: f */
    public CharSequence f26285f;

    /* renamed from: g */
    public AlertController$RecycleListView f26286g;

    /* renamed from: h */
    public View f26287h;

    /* renamed from: i */
    public int f26288i;

    /* renamed from: j */
    public int f26289j;

    /* renamed from: k */
    public int f26290k;

    /* renamed from: l */
    public int f26291l;

    /* renamed from: m */
    public int f26292m;

    /* renamed from: o */
    public Button f26294o;

    /* renamed from: p */
    public CharSequence f26295p;

    /* renamed from: q */
    public Message f26296q;

    /* renamed from: r */
    public Drawable f26297r;

    /* renamed from: s */
    public Button f26298s;

    /* renamed from: t */
    public CharSequence f26299t;

    /* renamed from: u */
    public Message f26300u;

    /* renamed from: v */
    public Drawable f26301v;

    /* renamed from: w */
    public Button f26302w;

    /* renamed from: x */
    public CharSequence f26303x;

    /* renamed from: y */
    public Message f26304y;

    /* renamed from: z */
    public Drawable f26305z;

    /* renamed from: n */
    public boolean f26293n = false;

    /* renamed from: B */
    public int f26264B = 0;

    /* renamed from: I */
    public int f26271I = -1;

    /* renamed from: Q */
    public final ViewOnClickListenerC1109d4 f26279Q = new ViewOnClickListenerC1109d4(2, this);

    public C1788s7(Context context, AlertDialog alertDialog, Window window) {
        this.f26280a = context;
        this.f26281b = alertDialog;
        this.f26282c = window;
        HandlerC1714q7 handlerC1714q7 = new HandlerC1714q7();
        handlerC1714q7.f25474b = new WeakReference(alertDialog);
        this.f26278P = handlerC1714q7;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.f26272J = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f26273K = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.f26274L = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f26275M = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f26276N = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.f26277O = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f26283d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        alertDialog.supportRequestWindowFeature(1);
    }

    /* renamed from: a */
    public static boolean m7339a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m7339a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static ViewGroup m7340b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* renamed from: c */
    public final void m7341c(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f26278P.obtainMessage(i, onClickListener);
        }
        if (i != -3) {
            if (i != -2) {
                if (i == -1) {
                    this.f26295p = charSequence;
                    this.f26296q = message;
                    this.f26297r = drawable;
                    return;
                }
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f26299t = charSequence;
            this.f26300u = message;
            this.f26301v = drawable;
            return;
        }
        this.f26303x = charSequence;
        this.f26304y = message;
        this.f26305z = drawable;
    }

    /* renamed from: d */
    public final void m7342d(int i) {
        this.f26265C = null;
        this.f26264B = i;
        ImageView imageView = this.f26266D;
        if (imageView != null) {
            if (i != 0) {
                imageView.setVisibility(0);
                this.f26266D.setImageResource(this.f26264B);
            } else {
                imageView.setVisibility(8);
            }
        }
    }
}
