package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class MockView extends View {

    /* renamed from: a */
    public final Paint f3057a;

    /* renamed from: b */
    public final Paint f3058b;

    /* renamed from: c */
    public final Paint f3059c;

    /* renamed from: d */
    public boolean f3060d;

    /* renamed from: e */
    public boolean f3061e;

    /* renamed from: f */
    public final Rect f3062f;

    /* renamed from: g */
    public int f3063g;

    /* renamed from: h */
    public int f3064h;

    /* renamed from: i */
    public int f3065i;

    /* renamed from: j */
    public int f3066j;
    protected String mText;

    public MockView(Context context) {
        super(context);
        this.f3057a = new Paint();
        this.f3058b = new Paint();
        this.f3059c = new Paint();
        this.f3060d = true;
        this.f3061e = true;
        this.mText = null;
        this.f3062f = new Rect();
        this.f3063g = Color.argb(255, 0, 0, 0);
        this.f3064h = Color.argb(255, 200, 200, 200);
        this.f3065i = Color.argb(255, 50, 50, 50);
        this.f3066j = 4;
        m619a(context, null);
    }

    /* renamed from: a */
    public final void m619a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MockView_mock_label) {
                    this.mText = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.f3060d = obtainStyledAttributes.getBoolean(index, this.f3060d);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.f3063g = obtainStyledAttributes.getColor(index, this.f3063g);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.f3065i = obtainStyledAttributes.getColor(index, this.f3065i);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.f3064h = obtainStyledAttributes.getColor(index, this.f3064h);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.f3061e = obtainStyledAttributes.getBoolean(index, this.f3061e);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mText == null) {
            try {
                this.mText = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        int i2 = this.f3063g;
        Paint paint = this.f3057a;
        paint.setColor(i2);
        paint.setAntiAlias(true);
        int i3 = this.f3064h;
        Paint paint2 = this.f3058b;
        paint2.setColor(i3);
        paint2.setAntiAlias(true);
        this.f3059c.setColor(this.f3065i);
        this.f3066j = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * this.f3066j);
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f3060d) {
            width--;
            height--;
            float f = width;
            float f2 = height;
            canvas.drawLine(RecyclerView.f7068F0, RecyclerView.f7068F0, f, f2, this.f3057a);
            canvas.drawLine(RecyclerView.f7068F0, f2, f, RecyclerView.f7068F0, this.f3057a);
            canvas.drawLine(RecyclerView.f7068F0, RecyclerView.f7068F0, f, RecyclerView.f7068F0, this.f3057a);
            canvas.drawLine(f, RecyclerView.f7068F0, f, f2, this.f3057a);
            canvas.drawLine(f, f2, RecyclerView.f7068F0, f2, this.f3057a);
            canvas.drawLine(RecyclerView.f7068F0, f2, RecyclerView.f7068F0, RecyclerView.f7068F0, this.f3057a);
        }
        String str = this.mText;
        if (str != null && this.f3061e) {
            int length = str.length();
            Paint paint = this.f3058b;
            Rect rect = this.f3062f;
            paint.getTextBounds(str, 0, length, rect);
            float width2 = (width - rect.width()) / 2.0f;
            float height2 = ((height - rect.height()) / 2.0f) + rect.height();
            rect.offset((int) width2, (int) height2);
            int i = rect.left;
            int i2 = this.f3066j;
            rect.set(i - i2, rect.top - i2, rect.right + i2, rect.bottom + i2);
            canvas.drawRect(rect, this.f3059c);
            canvas.drawText(this.mText, width2, height2, paint);
        }
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3057a = new Paint();
        this.f3058b = new Paint();
        this.f3059c = new Paint();
        this.f3060d = true;
        this.f3061e = true;
        this.mText = null;
        this.f3062f = new Rect();
        this.f3063g = Color.argb(255, 0, 0, 0);
        this.f3064h = Color.argb(255, 200, 200, 200);
        this.f3065i = Color.argb(255, 50, 50, 50);
        this.f3066j = 4;
        m619a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3057a = new Paint();
        this.f3058b = new Paint();
        this.f3059c = new Paint();
        this.f3060d = true;
        this.f3061e = true;
        this.mText = null;
        this.f3062f = new Rect();
        this.f3063g = Color.argb(255, 0, 0, 0);
        this.f3064h = Color.argb(255, 200, 200, 200);
        this.f3065i = Color.argb(255, 50, 50, 50);
        this.f3066j = 4;
        m619a(context, attributeSet);
    }
}
