/*
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2016 Douglas Nassif Roma Junior
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.douglasjunior.androidSimpleTooltip.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;
import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltipUtils;

/**
 * Created by douglas on 09/05/16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        findViewById(R.id.btn_simple).setOnClickListener(this);
        findViewById(R.id.btn_animated).setOnClickListener(this);
        findViewById(R.id.btn_overlay).setOnClickListener(this);
        findViewById(R.id.btn_maxwidth).setOnClickListener(this);
        findViewById(R.id.btn_outside).setOnClickListener(this);
        findViewById(R.id.btn_inside).setOnClickListener(this);
        findViewById(R.id.btn_inside_modal).setOnClickListener(this);
        findViewById(R.id.btn_modal_custom).setOnClickListener(this);
        findViewById(R.id.btn_no_arrow).setOnClickListener(this);
        findViewById(R.id.btn_custom_arrow).setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.fab) {
            new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text("Floating Action Button")
                    .gravity(Gravity.LEFT)
                    .build()
                    .show();

        } else if (v.getId() == R.id.btn_simple) {
            new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text(getString(R.string.btn_simple))
                    .gravity(Gravity.RIGHT)
                    .build()
                    .show();

        } else if (v.getId() == R.id.btn_animated) {
            new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text(getString(R.string.btn_animated))
                    .gravity(Gravity.TOP)
                    .animated(true)
                    .build()
                    .show();

        } else if (v.getId() == R.id.btn_overlay) {
            new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text(getString(R.string.btn_overlay))
                    .gravity(Gravity.LEFT)
                    .animated(true)
                    .transparentOverlay(false)
                    .build()
                    .show();

        } else if (v.getId() == R.id.btn_maxwidth) {
            new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text(getString(R.string.btn_maxwidth) + getString(R.string.btn_maxwidth) + getString(R.string.btn_maxwidth) + getString(R.string.btn_maxwidth) + getString(R.string.btn_maxwidth))
                    .gravity(Gravity.RIGHT)
                    .maxWidth(R.dimen.simpletooltip_max_width)
                    .build()
                    .show();

        } else if (v.getId() == R.id.btn_outside) {
            new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text(getString(R.string.btn_outside))
                    .gravity(Gravity.BOTTOM)
                    .dismissOnOutsideTouch(true)
                    .dismissOnInsideTouch(false)
                    .build()
                    .show();

        } else if (v.getId() == R.id.btn_inside) {
            new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text(getString(R.string.btn_inside))
                    .gravity(Gravity.LEFT)
                    .dismissOnOutsideTouch(false)
                    .dismissOnInsideTouch(true)
                    .build()
                    .show();

        } else if (v.getId() == R.id.btn_inside_modal) {
            new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text(getString(R.string.btn_inside_modal))
                    .gravity(Gravity.RIGHT)
                    .dismissOnOutsideTouch(false)
                    .dismissOnInsideTouch(true)
                    .modal(true)
                    .build()
                    .show();

        } else if (v.getId() == R.id.btn_modal_custom) {
            final SimpleTooltip tooltip = new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text(getString(R.string.btn_modal_custom))
                    .gravity(Gravity.TOP)
                    .dismissOnOutsideTouch(false)
                    .dismissOnInsideTouch(false)
                    .modal(true)
                    .animated(true)
                    .animationDuration(2000)
                    .animationPadding((int) SimpleTooltipUtils.pxFromDp(50))
                    .contentView(R.layout.tooltip_custom, R.id.tv_text)
                    .build();

            tooltip.findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v2) {
                    tooltip.dismiss();
                    new SimpleTooltip.Builder(v.getContext())
                            .anchorView(v)
                            .text(getString(R.string.btn_next))
                            .gravity(Gravity.BOTTOM)
                            .build()
                            .show();
                }
            });

            tooltip.show();
        } else if (v.getId() == R.id.btn_no_arrow) {
            new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text(getString(R.string.btn_no_arrow))
                    .gravity(Gravity.LEFT)
                    .showArrow(false)
                    .modal(true)
                    .build()
                    .show();

        } else if (v.getId() == R.id.btn_custom_arrow) {
            new SimpleTooltip.Builder(this)
                    .anchorView(v)
                    .text(getString(R.string.btn_custom_arrow))
                    .gravity(Gravity.RIGHT)
                    .modal(true)
                    .arrowDrawable(android.R.drawable.ic_media_previous)
                    .arrowHeight((int) SimpleTooltipUtils.pxFromDp(50))
                    .arrowWidth((int) SimpleTooltipUtils.pxFromDp(50))
                    .build()
                    .show();

        }
    }
}
