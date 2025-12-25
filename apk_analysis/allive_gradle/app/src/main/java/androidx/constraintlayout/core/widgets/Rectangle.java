package androidx.constraintlayout.core.widgets;

/* loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x */
    public int f2548x;

    /* renamed from: y */
    public int f2549y;

    public boolean contains(int i, int i2) {
        int i3;
        int i4 = this.f2548x;
        if (i >= i4 && i < i4 + this.width && i2 >= (i3 = this.f2549y) && i2 < i3 + this.height) {
            return true;
        }
        return false;
    }

    public int getCenterX() {
        return (this.f2548x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f2549y + this.height) / 2;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.f2548x = i;
        this.f2549y = i2;
        this.width = i3;
        this.height = i4;
    }
}
