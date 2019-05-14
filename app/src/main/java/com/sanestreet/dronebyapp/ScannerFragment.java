package com.sanestreet.dronebyapp;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.samples.vision.barcodereader.BarcodeCapture;
import com.google.android.gms.samples.vision.barcodereader.BarcodeGraphic;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import xyz.belvi.mobilevisionbarcodescanner.BarcodeRetriever;

public class ScannerFragment extends Fragment implements BarcodeRetriever {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TEXT = "text";

    // TODO: Rename and change types of parameters
    private String mText;

    private OnFragmentInteractionListener mListener;

    private EditText textBarcodeScanResult;
    private BarcodeCapture barcodeCapture;
    private Button buttonOkFragment;

    public ScannerFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ScannerFragment newInstance(String text) {
        ScannerFragment fragment = new ScannerFragment();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString(TEXT);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scanner, container, false);

        barcodeCapture = (BarcodeCapture)getChildFragmentManager().findFragmentById(R.id.barcode);
        buttonOkFragment = view.findViewById(R.id.buttonOkFragment);
        textBarcodeScanResult = view.findViewById(R.id.textBarcodeScanResult);
        textBarcodeScanResult.setText(mText);
        textBarcodeScanResult.requestFocus();
        barcodeCapture.setRetrieval(this);



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void sendBack(String sendBackText) {
        if (mListener != null) {
            mListener.onFragmentInteraction(sendBackText);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String sendBackText);
    }

    //Barcode scanner
    @Override
    public void onPermissionRequestDenied() {

    }

    @Override
    public void onRetrievedFailed(String reason) {

    }

    @Override
    public void onRetrieved(final Barcode barcode) {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textBarcodeScanResult.setText(barcode.displayValue);

                Toast.makeText(getActivity(), barcode.displayValue, Toast.LENGTH_LONG).show();

                buttonOkFragment.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){

                        String sendBackText = textBarcodeScanResult.getText().toString();
                        sendBack(sendBackText);
                    }
                });

            }
        });
                //textBarcodeScanResult.setText(barcode.displayValue);
                //sendBack(textBarcodeScanResult.getText().toString());


    }

    @Override
    public void onRetrievedMultiple(Barcode closetToClick, List<BarcodeGraphic> barcode) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }
}
