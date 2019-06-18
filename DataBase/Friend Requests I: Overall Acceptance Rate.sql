# Write your MySQL query statement below
select ifnull(
    round((select count(distinct requester_id, accepter_id) from request_accepted) / 
          (select count(distinct sender_id, send_to_id) from friend_request),2),0
) as accept_rate
