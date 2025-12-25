package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

/* renamed from: androidx.appcompat.widget.f */
/* loaded from: classes.dex */
public final class C0097f implements ResourceManagerInternal.ResourceManagerHooks {

    /* renamed from: a */
    public final int[] f1614a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: b */
    public final int[] f1615b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

    /* renamed from: c */
    public final int[] f1616c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

    /* renamed from: d */
    public final int[] f1617d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: e */
    public final int[] f1618e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

    /* renamed from: f */
    public final int[] f1619f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

    /* renamed from: a */
    public static boolean m317a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static ColorStateList m318b(int i, Context context) {
        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{ThemeUtils.f1480b, ThemeUtils.f1482d, ThemeUtils.f1481c, ThemeUtils.f1484f}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
    }

    /* renamed from: c */
    public static LayerDrawable m319c(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawable = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
        Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
        if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawable;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawable.draw(canvas);
            bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable2 = new BitmapDrawable(createBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawable2;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawable2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    /* renamed from: d */
    public static void m320d(Drawable drawable, int i, PorterDuff.Mode mode) {
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = AppCompatDrawableManager.f1147b;
        }
        mutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
    }

    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
    public final Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
        if (i == R.drawable.abc_cab_background_top_material) {
            return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (i == R.drawable.abc_ratingbar_material) {
            return m319c(resourceManagerInternal, context, R.dimen.abc_star_big);
        }
        if (i == R.drawable.abc_ratingbar_indicator_material) {
            return m319c(resourceManagerInternal, context, R.dimen.abc_star_medium);
        }
        if (i == R.drawable.abc_ratingbar_small_material) {
            return m319c(resourceManagerInternal, context, R.dimen.abc_star_small);
        }
        return null;
    }

    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
    public final ColorStateList getTintListForDrawableRes(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return AppCompatResources.getColorStateList(context, R.color.abc_tint_edittext);
        }
        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
            return AppCompatResources.getColorStateList(context, R.color.abc_tint_switch_track);
        }
        if (i == R.drawable.abc_switch_thumb_material) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            int i2 = R.attr.colorSwitchThumbNormal;
            ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, i2);
            if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
                int[] iArr3 = ThemeUtils.f1480b;
                iArr[0] = iArr3;
                iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
                iArr[1] = ThemeUtils.f1483e;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.f1484f;
                iArr2[2] = themeAttrColorStateList.getDefaultColor();
            } else {
                iArr[0] = ThemeUtils.f1480b;
                iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, i2);
                iArr[1] = ThemeUtils.f1483e;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.f1484f;
                iArr2[2] = ThemeUtils.getThemeAttrColor(context, i2);
            }
            return new ColorStateList(iArr, iArr2);
        }
        if (i == R.drawable.abc_btn_default_mtrl_shape) {
            return m318b(ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal), context);
        }
        if (i == R.drawable.abc_btn_borderless_material) {
            return m318b(0, context);
        }
        if (i == R.drawable.abc_btn_colored_material) {
            return m318b(ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent), context);
        }
        if (i != R.drawable.abc_spinner_mtrl_am_alpha && i != R.drawable.abc_spinner_textfield_background_material) {
            if (m317a(i, this.f1615b)) {
                return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
            }
            if (m317a(i, this.f1618e)) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_default);
            }
            if (m317a(i, this.f1619f)) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        return AppCompatResources.getColorStateList(context, R.color.abc_tint_spinner);
    }

    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
    public final PorterDuff.Mode getTintModeForDrawableRes(int i) {
        if (i == R.drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
    public final boolean tintDrawable(Context context, int i, Drawable drawable) {
        if (i == R.drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
            int i2 = R.attr.colorControlNormal;
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, i2);
            PorterDuff.Mode mode = AppCompatDrawableManager.f1147b;
            m320d(findDrawableByLayerId, themeAttrColor, mode);
            m320d(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, i2), mode);
            m320d(layerDrawable.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), mode);
            return true;
        }
        if (i != R.drawable.abc_ratingbar_material && i != R.drawable.abc_ratingbar_indicator_material && i != R.drawable.abc_ratingbar_small_material) {
            return false;
        }
        LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
        Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
        int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorControlNormal);
        PorterDuff.Mode mode2 = AppCompatDrawableManager.f1147b;
        m320d(findDrawableByLayerId2, disabledThemeAttrColor, mode2);
        Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress);
        int i3 = R.attr.colorControlActivated;
        m320d(findDrawableByLayerId3, ThemeUtils.getThemeAttrColor(context, i3), mode2);
        m320d(layerDrawable2.findDrawableByLayerId(android.R.id.progress), ThemeUtils.getThemeAttrColor(context, i3), mode2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004e  */
    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean tintDrawableUsingColorFilter(Context context, int i, Drawable drawable) {
        PorterDuff.Mode mode;
        int i2;
        int i3;
        boolean z;
        PorterDuff.Mode mode2 = AppCompatDrawableManager.f1147b;
        if (m317a(i, this.f1614a)) {
            i3 = R.attr.colorControlNormal;
        } else if (m317a(i, this.f1616c)) {
            i3 = R.attr.colorControlActivated;
        } else {
            if (m317a(i, this.f1617d)) {
                mode2 = PorterDuff.Mode.MULTIPLY;
            } else {
                if (i == R.drawable.abc_list_divider_mtrl_alpha) {
                    z = true;
                    i2 = Math.round(40.8f);
                    i3 = 16842800;
                    mode = mode2;
                } else if (i != R.drawable.abc_dialog_material_background) {
                    mode = mode2;
                    i2 = -1;
                    i3 = 0;
                    z = false;
                }
                if (!z) {
                    return false;
                }
                Drawable mutate = drawable.mutate();
                mutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i3), mode));
                if (i2 != -1) {
                    mutate.setAlpha(i2);
                }
                return true;
            }
            mode = mode2;
            i2 = -1;
            i3 = 16842801;
            z = true;
            if (!z) {
            }
        }
        mode = mode2;
        i2 = -1;
        z = true;
        if (!z) {
        }
    }
}
