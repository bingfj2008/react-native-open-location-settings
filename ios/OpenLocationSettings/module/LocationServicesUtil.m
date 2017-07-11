//
//  LocationServicesUtil.m
//
//  Created by mac_vm on 2017/07/10.
//  Copyright © 2017年 Facebook. All rights reserved.
//

#import "LocationServicesUtil.h"

@implementation LocationServicesUtil

RCT_EXPORT_MODULE();

//RCT_EXPORT_METHOD(openLocationSettings:(RCTResponseSenderBlock) callback)
//{
//    NSLog(@"[openLocationSettings]Start!!!!");
//    [[UIApplication sharedApplication] openURL: [NSURL URLWithString:@"prefs:root=LOCATION_SERVICES"]];
//    callback(@[@"true"]);
//}

//
//
//
RCT_EXPORT_METHOD(openSystemLocationSettings){
  NSLog(@"[openSystemLocationSettings]Start!!!!");
  CGFloat systemVersion = [[UIDevice currentDevice].systemVersion floatValue];
  NSLog(@"systemVersion:[%f]", systemVersion);
  if (systemVersion < 10) {
    [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"App-Prefs:root=Privacy&path=LOCATION"]];
  }else{
    [[UIApplication sharedApplication]openURL:[NSURL URLWithString:@"App-Prefs:root=Privacy&path=LOCATION"]
                                      options:[NSDictionary dictionary]
                                      completionHandler:nil];
  }
}

//
//
//
RCT_EXPORT_METHOD(openAppLocationSettings){
  NSLog(@"[openAppLocationSettings]Start!!!!");
  [[UIApplication sharedApplication] openURL:[NSURL URLWithString:UIApplicationOpenSettingsURLString]];
}

@end
