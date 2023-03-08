# GlobalMentoring_Task5_SalarySociety

Assume, we have REST endpoint that returns a list of hired Employees.

1. REST endpoint is wrapped by Java service class that consuming this endpoint.
2. Fetch a list of Employee objects asynchronously by calling the hiredEmployees().
3. Join another CompletionStage<List> that takes care of filling the salary of each hired employee, by calling the getSalary(hiredEmployeeId) method which returns a CompletionStage that asynchronously fetches the salary (again could be consuming a REST endpoint).
4. When all Employee objects are filled with their salaries, we end up with a List<CompletionStage>, so we call <special operation on CF> to get a final stage that completes upon completion of all these stages.
5. Print hired Employees with their salaries via <special operation on CF> on final stage.
