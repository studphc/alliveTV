package p000;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class k80 extends o63 {

    /* renamed from: u */
    public final TextView f20775u;

    /* renamed from: v */
    public final f80 f20776v;

    /* renamed from: w */
    public boolean f20777w = true;

    public k80(TextView textView) {
        this.f20775u = textView;
        this.f20776v = new f80(textView);
    }

    @Override // p000.o63
    /* renamed from: I */
    public final void mo5505I(boolean z) {
        if (z) {
            mo5507Q();
        }
    }

    @Override // p000.o63
    /* renamed from: J */
    public final void mo5506J(boolean z) {
        this.f20777w = z;
        mo5507Q();
        TextView textView = this.f20775u;
        textView.setFilters(mo5509o(textView.getFilters()));
    }

    @Override // p000.o63
    /* renamed from: Q */
    public final void mo5507Q() {
        TextView textView = this.f20775u;
        textView.setTransformationMethod(mo5508R(textView.getTransformationMethod()));
    }

    @Override // p000.o63
    /* renamed from: R */
    public final TransformationMethod mo5508R(TransformationMethod transformationMethod) {
        if (this.f20777w) {
            if (!(transformationMethod instanceof o80) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                return new o80(transformationMethod);
            }
            return transformationMethod;
        }
        if (transformationMethod instanceof o80) {
            return ((o80) transformationMethod).f23660a;
        }
        return transformationMethod;
    }

    @Override // p000.o63
    /* renamed from: o */
    public final InputFilter[] mo5509o(InputFilter[] inputFilterArr) {
        if (!this.f20777w) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof f80) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() != 0) {
                int length = inputFilterArr.length;
                InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    if (sparseArray.indexOfKey(i3) < 0) {
                        inputFilterArr2[i2] = inputFilterArr[i3];
                        i2++;
                    }
                }
                return inputFilterArr2;
            }
            return inputFilterArr;
        }
        int length2 = inputFilterArr.length;
        int i4 = 0;
        while (true) {
            f80 f80Var = this.f20776v;
            if (i4 < length2) {
                if (inputFilterArr[i4] != f80Var) {
                    i4++;
                } else {
                    return inputFilterArr;
                }
            } else {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = f80Var;
                return inputFilterArr3;
            }
        }
    }

    @Override // p000.o63
    /* renamed from: s */
    public final boolean mo5510s() {
        return this.f20777w;
    }
}
