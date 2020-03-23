// WARNING
//
// This file has been generated automatically by Visual Studio to store outlets and
// actions made in the UI designer. If it is removed, they will be lost.
// Manual changes to this file may not be handled correctly.
//
using Foundation;
using System.CodeDom.Compiler;

namespace auto_parts_shop
{
	[Register ("ViewController")]
	partial class ViewController
	{
		[Outlet]
		AppKit.NSTextField lab1 { get; set; }

		[Action ("but1:")]
		partial void but1 (AppKit.NSButton sender);

		[Action ("ButtonPressed:")]
		partial void ButtonPressed (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (lab1 != null) {
				lab1.Dispose ();
				lab1 = null;
			}
		}
	}
}
