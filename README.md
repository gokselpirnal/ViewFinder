# ViewFinder

#### For Activities
~~Button myButton = (Button) findViewById(R.id.my_button)~~
```java
@FindView(R.id.my_text_view)
TextView myTextView;
@FindView(R.id.my_button) 
Button myButton;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ViewFinder.bind(this);
    
    myButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            myTextView.setText("Hello World!");
        }
    });
}
```

#### For Fragments
~~Button myButton = (Button) view.findViewById(R.id.my_button)~~

```java
@FindViewGroup(R.layout.my_fragment)
public class MyFragment extends Fragment {

    @FindView(R.id.my_text_view)
    TextView myTextView;
    @FindView(R.id.my_button)
    TextView myButton;
    
    //...
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = ViewFinder.bind(this, inflater, container);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setText("Hello World!");
            }
        });

        return view;
    }
}
```
