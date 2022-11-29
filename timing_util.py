#
# Extra file for doing timing based tests on lab 5
#   DANIEL KLUVER 22 Feb 2020
#


import time

lastStart = None
def start_timing():
    """Start timing an event, this returns nothing.
    If you are timing multiple events, you should call this function once before each function call"""
    global lastStart
    lastStart = time.monotonic()

def get_elapsed_time():
    """ returns the number of seconds since the most recent call to start_timing
     This should be measured more precisely than seconds, meaning it returns a float
     (fractions of seconds should be possible)"""
    if lastStart is None:
        print("[ERROR] Call start_timing before get_elapsed_time!")
        exit(1)
    else:
        return time.monotonic() - lastStart

