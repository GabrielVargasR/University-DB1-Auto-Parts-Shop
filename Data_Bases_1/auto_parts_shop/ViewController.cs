using System;

using AppKit;
using Foundation;

namespace auto_parts_shop
{
    public partial class ViewController : NSViewController
    {
        public ViewController(IntPtr handle) : base(handle)
        {
        }

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();

            // Do any additional setup after loading the view.
        }

        public override NSObject RepresentedObject
        {
            get
            {
                return base.RepresentedObject;
            }
            set
            {
                base.RepresentedObject = value;
                // Update the view, if already loaded.
            }
        }

        partial void ButtonPressed(NSObject sender)
        {
            //lab1.StringValue = "adios";
            if (lab1.Hidden)
            {
                lab1.Hidden = false;
            }
            else
            {
                lab1.Hidden = true;
            }
        }
    }
}
